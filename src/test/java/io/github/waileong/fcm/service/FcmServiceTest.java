package io.github.waileong.fcm.service;

import jakarta.validation.Validator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import io.github.waileong.fcm.config.FcmAutoConfiguration;
import io.github.waileong.fcm.service.domain.FcmMessage;
import io.github.waileong.fcm.service.domain.FcmNotification;
import io.github.waileong.fcm.service.domain.FcmSendRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link FcmService} implementations within a Spring Boot context.
 * <p>
 * This test class is designed to verify the functionality of the FCM service, specifically focusing on the
 * ability to send notifications through Firebase Cloud Messaging. It leverages Spring Boot's testing framework
 * to load a minimal application context, ensuring the FcmService and its dependencies are correctly configured.
 * </p>
 *
 * <p>Note: This test is disabled by default and requires a valid FCM device token to execute.</p>
 *
 * @author Wai Leong
 */
@SpringBootTest(classes = FcmServiceTest.ContextConfiguration.class,
        webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ActiveProfiles("test")
@Disabled
public class FcmServiceTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    static {
        // Enable detailed HTTP client logging for debugging purposes
        System.setProperty("jdk.httpclient.HttpClient.log", "all");
    }

    @Autowired
    private FcmService fcmService;

    @Test
    public void testSendNotification() throws Exception {
        String deviceToken = "";
        String title = "FCM Title";
        String message = "FCM Message";
        FcmSendRequest sendRequest = FcmSendRequest.Builder.aFcmSendRequest()
                .message(FcmMessage.Builder.aFcmMessage()
                        .token(deviceToken)
                        .notification(FcmNotification.Builder.aFcmNotification()
                                .title(title)
                                .body(message)
                                .build())
                        .build())
                .build();
        FcmMessage response = fcmService.send(sendRequest);
        assertThat(response).isNotNull();
    }

    /**
     * Spring Boot test configuration class that imports FCM and task execution configurations.
     * <p>
     * Also declares beans for {@link Validator} and {@link MethodValidationPostProcessor} to enable
     * method-level validation within the test context.
     * </p>
     */
    @Configuration(proxyBeanMethods = false)
    @Import({FcmAutoConfiguration.class, TaskExecutionAutoConfiguration.class})
    public static class ContextConfiguration {
        @Bean
        public Validator validator() {
            return new LocalValidatorFactoryBean();
        }

        @Bean
        public MethodValidationPostProcessor methodValidationPostProcessor() {
            return new MethodValidationPostProcessor();
        }
    }
}
