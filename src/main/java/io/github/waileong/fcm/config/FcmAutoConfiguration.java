package io.github.waileong.fcm.config;

import io.github.waileong.fcm.service.impl.FcmServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;
import org.springframework.web.client.RestClient;

/**
 * Provides automatic configuration for Firebase Cloud Messaging (FCM) integration in Spring Boot applications.
 * This class is responsible for setting up FCM-related beans, including service implementations and REST clients
 * necessary for communicating with FCM services. It is designed to be autoconfigured after the TaskExecutionAutoConfiguration
 * class and is given the highest precedence in autoconfiguration ordering to ensure that FCM services are available
 * early in the application context.
 * <p>
 * The configuration reads FCM properties from application configuration files and initializes required FCM configuration
 * classes. It also makes use of Spring's {@link Import} annotation to include FCM authentication and connection configurations,
 * streamlining the setup process for FCM integration.
 *
 * @author Wai Leong
 */
@AutoConfiguration(after = TaskExecutionAutoConfiguration.class)
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
@EnableConfigurationProperties(FcmProperties.class)
@Import({FcmAuthenticationConfiguration.class, FcmConnectionConfiguration.class})
public class FcmAutoConfiguration {

    /**
     * Defines a bean for the FCM service implementation. This service is a central component for interacting with
     * Firebase Cloud Messaging, providing a high-level API for sending messages and managing FCM interactions.
     * <p>
     * The method injects a pre-configured {@link RestClient} that is tailored for FCM communication, ensuring that
     * the service can perform HTTP requests to FCM with appropriate headers, error handling, and authentication.
     *
     * @param fcmRestClient The {@link RestClient} qualified for FCM, pre-configured with necessary settings for
     *                      communication with Firebase Cloud Messaging services.
     * @return An instance of {@link FcmServiceImpl}, ready to be used for FCM operations within the application.
     */
    @Bean
    public FcmServiceImpl fcmService(@Qualifier("fcmRestClient") RestClient fcmRestClient) {
        return new FcmServiceImpl(fcmRestClient);
    }
}
