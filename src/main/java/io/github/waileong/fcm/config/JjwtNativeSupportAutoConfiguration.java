package io.github.waileong.fcm.config;

import io.jsonwebtoken.impl.DefaultClaimsBuilder;
import io.jsonwebtoken.impl.DefaultJwtBuilder;
import io.jsonwebtoken.impl.DefaultJwtHeaderBuilder;
import io.jsonwebtoken.impl.DefaultJwtParserBuilder;
import io.jsonwebtoken.impl.io.StandardCompressionAlgorithms;
import io.jsonwebtoken.impl.security.*;
import io.jsonwebtoken.security.Jwk;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.core.Ordered;

/**
 * Autoconfiguration class for enabling native support for the JJWT library.
 * This class registers reflection metadata for various JJWT-related classes
 * and components to support their usage in native images.
 * <p>
 * The configuration is loaded automatically through Spring's autoconfiguration
 * mechanism and is applied with the highest precedence order.
 * <p>
 * This class ensures that key JJWT classes, algorithms, and utilities required
 * for JSON Web Token (JWT) handling and JSON Web Key (JWK) processing are properly
 * configured for reflection in native environments.
 * <p>
 * The `@RegisterReflectionForBinding` annotation is used to register a comprehensive
 * list of classes that require reflection binding, enabling proper functionality
 * in native image contexts.
 */
@AutoConfiguration
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
@RegisterReflectionForBinding({
        Jwk.class,
        DefaultJwtHeaderBuilder.class,
        DefaultClaimsBuilder.class,
        DefaultJwtBuilder.class,
        DefaultJwtParserBuilder.class,
        StandardEncryptionAlgorithms.class,
        StandardKeyAlgorithms.class,
        StandardSecureDigestAlgorithms.class,
        StandardCompressionAlgorithms.class,
        JwksBridge.class,
        DefaultDynamicJwkBuilder.class,
        DefaultJwkParserBuilder.class,
        DefaultJwkSetBuilder.class,
        DefaultJwkSetParserBuilder.class,
        StandardCurves.class,
        StandardHashAlgorithms.class,
        StandardKeyOperations.class,
        DefaultKeyOperationBuilder.class,
        DefaultKeyOperationPolicyBuilder.class,
        KeysBridge.class
})
public class JjwtNativeSupportAutoConfiguration {
}
