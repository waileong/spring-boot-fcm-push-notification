package io.github.waileong.fcm.config;

import io.github.waileong.fcm.authentication.FcmJwtToken;
import io.github.waileong.fcm.authentication.FcmJwtTokenPooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for Firebase Cloud Messaging (FCM) authentication. This class sets up a pool of FCM JWT tokens,
 * optimizing the management and reuse of these tokens for communicating with FCM. The configuration is designed to
 * work within a Spring application context, leveraging Spring's dependency injection to provide configured beans.
 * <p>
 * The configuration disables proxy bean methods to reduce runtime overhead, suitable for environments where inter-bean
 * method calls are not necessary.
 * </p>
 *
 * @author Wai Leong
 */
@Configuration(proxyBeanMethods = false)
public class FcmAuthenticationConfiguration {

    /**
     * Creates a factory for pooled FCM JWT tokens. This factory is responsible for the lifecycle management of
     * FcmJwtToken instances, used for authenticating requests to Firebase Cloud Messaging.
     *
     * @param fcmProperties Properties for FCM configuration, including credentials.
     * @return A new instance of {@link FcmJwtTokenPooledObjectFactory}, configured with FCM credentials.
     */
    @Bean
    public FcmJwtTokenPooledObjectFactory fcmJwtTokenPooledObjectFactory(FcmProperties fcmProperties) {
        return new FcmJwtTokenPooledObjectFactory(fcmProperties.getCredential());
    }

    /**
     * Configures and provides a pool of FCM JWT tokens. This method sets up a {@link GenericObjectPool} for
     * {@link FcmJwtToken}, optimizing token reuse and management for FCM authentication. The pool configuration
     * is customized according to the FCM properties, including maximum pool size and validation settings.
     *
     * @param fcmJwtTokenPooledObjectFactory The factory to create and manage FcmJwtToken instances.
     * @param fcmProperties                  The properties for FCM configuration, used to customize the pool settings.
     * @return A configured {@link GenericObjectPool} of {@link FcmJwtToken} for efficient token management.
     */
    @Bean
    public GenericObjectPool<FcmJwtToken> fcmJwtTokenPool(
            FcmJwtTokenPooledObjectFactory fcmJwtTokenPooledObjectFactory,
            FcmProperties fcmProperties) {
        GenericObjectPoolConfig<FcmJwtToken> config = new GenericObjectPoolConfig<>();
        config.setJmxEnabled(false);
        config.setMaxTotal(fcmProperties.getJwtTokenPoolSetting().getMaxTotal());
        config.setMaxIdle(fcmProperties.getJwtTokenPoolSetting().getMaxIdle());
        config.setTestOnBorrow(true);
        config.setTestOnReturn(true);
        config.setTestWhileIdle(true);
        return new GenericObjectPool<>(fcmJwtTokenPooledObjectFactory, config);
    }
}
