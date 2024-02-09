package io.github.waileong.fcm.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.waileong.fcm.exception.FcmRestClientResponseErrorHandler;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ssl.SslBundle;
import org.springframework.boot.ssl.SslBundles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClient;

import java.net.http.HttpClient;
import java.util.concurrent.Executor;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration.APPLICATION_TASK_EXECUTOR_BEAN_NAME;

/**
 * Configuration class for managing connections to Firebase Cloud Messaging (FCM). This class provides beans to
 * configure HTTP request factories, object mappers, message converters, and response error handlers specifically
 * tailored for FCM integration. It supports custom SSL contexts for secure connections and leverages Spring's
 * dependency injection to configure and instantiate the necessary components.
 * <p>
 * The configuration is designed to work within a Spring application context, optimizing for efficient communication
 * with FCM services by providing a customized REST client setup.
 *
 * @author Wai Leong
 */
@Configuration(proxyBeanMethods = false)
public class FcmConnectionConfiguration {

    /**
     * Configures a {@link ClientHttpRequestFactory} for FCM, supporting custom SSL contexts and executor
     * configurations. This factory is used to create HTTP requests for communicating with FCM services, allowing
     * for customization of connection and read timeouts.
     *
     * @param applicationTaskExecutor  An ObjectProvider for the application's task executor, used for asynchronous
     *                                 request processing.
     * @param sslBundlesObjectProvider An ObjectProvider for SSLBundles, used to obtain SSL configurations.
     * @param fcmProperties            Properties containing FCM connection settings, including timeouts and SSL bundle names.
     * @return A configured {@link ClientHttpRequestFactory} instance for FCM communication.
     */
    @Bean
    public ClientHttpRequestFactory fcmClientHttpRequestFactory(
            @Qualifier(APPLICATION_TASK_EXECUTOR_BEAN_NAME) ObjectProvider<Executor> applicationTaskExecutor,
            ObjectProvider<SslBundles> sslBundlesObjectProvider,
            FcmProperties fcmProperties) {
        final FcmProperties.ConnectionSetting connection = fcmProperties.getConnection();
        HttpClient.Builder builder = HttpClient.newBuilder();
        if (connection.getConnectTimeout() != null) {
            builder.connectTimeout(connection.getConnectTimeout());
        }
        SslBundles sslBundles = sslBundlesObjectProvider.getIfAvailable();
        if (sslBundles != null && !isBlank(connection.getSslBundleName())) {
            SslBundle bundle = sslBundles.getBundle(connection.getSslBundleName());
            builder.sslContext(bundle.createSslContext());
        }
        HttpClient httpClient = builder.build();
        Executor executor = applicationTaskExecutor.getIfAvailable();
        JdkClientHttpRequestFactory jdkClientHttpRequestFactory = executor != null
                ? new JdkClientHttpRequestFactory(httpClient, executor)
                : new JdkClientHttpRequestFactory(httpClient);
        if (connection.getReadTimeout() != null) {
            jdkClientHttpRequestFactory.setReadTimeout(connection.getReadTimeout());
        }

        return jdkClientHttpRequestFactory;
    }

    /**
     * Provides a customized {@link ObjectMapper} for FCM, configured to exclude null values from serialization.
     * This object mapper is used for converting Java objects to JSON and vice versa, specifically tailored for FCM
     * data structures.
     *
     * @return A configured {@link ObjectMapper} instance for FCM.
     */
    @Bean
    public ObjectMapper fcmObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper;
    }

    /**
     * Creates a {@link MappingJackson2HttpMessageConverter} using the provided FCM {@link ObjectMapper}.
     * This message converter is used for HTTP message conversion, specifically for JSON content types in FCM requests
     * and responses.
     *
     * @param fcmObjectMapper The custom {@link ObjectMapper} for FCM.
     * @return A configured {@link MappingJackson2HttpMessageConverter} instance for FCM communication.
     */
    @Bean
    public MappingJackson2HttpMessageConverter fcmMessageConverter(
            @Qualifier("fcmObjectMapper") ObjectMapper fcmObjectMapper) {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(fcmObjectMapper);
        return converter;
    }

    /**
     * Provides an {@link FcmRestClientResponseErrorHandler} for handling errors in FCM REST client responses.
     * This error handler utilizes the FCM {@link ObjectMapper} to parse error responses from FCM services.
     *
     * @param fcmObjectMapper The custom {@link ObjectMapper} for FCM.
     * @return A configured {@link FcmRestClientResponseErrorHandler} instance.
     */
    @Bean
    public FcmRestClientResponseErrorHandler fcmRestClientResponseErrorHandler(
            @Qualifier("fcmObjectMapper") ObjectMapper fcmObjectMapper) {
        return new FcmRestClientResponseErrorHandler(fcmObjectMapper);
    }

    /**
     * Configures and provides a {@link RestClient} tailored for FCM communication. This REST client is configured
     * with FCM-specific headers, message converters, and error handlers. It is designed for sending messages to FCM services, using a base URL constructed
     * from the provided FCM project ID.
     *
     * @param fcmClientHttpRequestFactory       The HTTP request factory for FCM.
     * @param fcmMessageConverter               The message converter for FCM.
     * @param fcmRestClientResponseErrorHandler The error handler for FCM responses.
     * @param fcmProperties                     Properties containing the FCM credential and project ID.
     * @return A configured {@link RestClient} instance for FCM communication.
     */
    @Bean
    public RestClient fcmRestClient(
            @Qualifier("fcmClientHttpRequestFactory") ClientHttpRequestFactory fcmClientHttpRequestFactory,
            @Qualifier("fcmMessageConverter") MappingJackson2HttpMessageConverter fcmMessageConverter,
            @Qualifier("fcmRestClientResponseErrorHandler") FcmRestClientResponseErrorHandler fcmRestClientResponseErrorHandler,
            FcmProperties fcmProperties) {
        String projectId = fcmProperties.getCredential().getProjectId();
        if (isBlank(projectId)) {
            throw new IllegalArgumentException("A Project ID is required for Firebase Cloud Messaging (FCM). " +
                    "Please retrieve it from the 'project_id' field in the downloaded Firebase Admin SDK JSON file. " +
                    "Then, input it into the configuration for fcm.credential.project-id");
        }
        return RestClient.builder()
                .baseUrl("https://fcm.googleapis.com/v1/projects/" + projectId + "/messages:send")
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .requestFactory(fcmClientHttpRequestFactory)
                .messageConverters(httpMessageConverters -> {
                    // override the default message converters
                    httpMessageConverters.clear();
                    httpMessageConverters.add(fcmMessageConverter);
                })
                .defaultStatusHandler(fcmRestClientResponseErrorHandler)
                .build();
    }


}
