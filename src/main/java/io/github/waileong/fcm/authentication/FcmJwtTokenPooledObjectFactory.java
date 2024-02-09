package io.github.waileong.fcm.authentication;

import io.github.waileong.fcm.config.FcmProperties;
import io.github.waileong.fcm.util.RSAKeyPairUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.util.Date;

import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * A factory for creating, wrapping, and validating {@link FcmJwtToken} objects for use in a pool.
 * This class extends {@link BasePooledObjectFactory} and is tailored to generate JWT tokens required
 * for authenticating with Firebase Cloud Messaging (FCM) services. It utilizes the credentials provided
 * by {@link FcmProperties.Credential} to generate tokens with a specific lifetime and signs them using
 * RS256 algorithm.
 * <p>
 * The generated tokens include information such as the issuer, subject, and audience, and are signed with
 * a private key. This class ensures that each token is valid for a specified duration (typically one hour),
 * and provides mechanisms to validate the tokens before they are reused from the pool.
 *
 * @author Wai Leong
 */
public class FcmJwtTokenPooledObjectFactory extends BasePooledObjectFactory<FcmJwtToken> {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final FcmProperties.Credential credential;
    private static final String FCM_ENDPOINT_URL = "https://fcm.googleapis.com/";

    /**
     * Constructs a new {@link FcmJwtTokenPooledObjectFactory} with the given FCM credentials.
     *
     * @param credential The FCM credentials used to sign and issue JWT tokens.
     */
    public FcmJwtTokenPooledObjectFactory(FcmProperties.Credential credential) {
        this.credential = credential;
    }

    /**
     * Creates a new {@link FcmJwtToken} instance, signed with RS256 algorithm using the provided FCM credentials.
     * The token is configured with an issuer, subject, audience, issuance time, and expiration time.
     *
     * @return A new {@link FcmJwtToken} instance, ready for use.
     * @throws Exception If there is an error during token creation, such as an issue with key parsing.
     */
    @Override
    public FcmJwtToken create() throws Exception {
        Instant now = Instant.now();
        Instant expiration = now.plus(credential.getJwtExpireDuration());
        String privateKeyId = credential.getPrivateKeyId();
        String clientEmail = credential.getClientEmail();
        String privateKey = credential.getPrivateKey();

        if (isBlank(privateKeyId)) {
            throw new IllegalArgumentException(
                    "A Private Key ID is required for Firebase Cloud Messaging (FCM). " +
                            "Please retrieve it from the 'private_key_id' field in the downloaded Firebase Admin SDK JSON file. " +
                            "Then, input it into the configuration for fcm.credential.private-key-id");
        }
        if (isBlank(privateKey)) {
            throw new IllegalArgumentException(
                    "A Private Key is required for Firebase Cloud Messaging (FCM). " +
                            "Please retrieve it from the 'private_key' field in the downloaded Firebase Admin SDK JSON file. " +
                            "Then, input it into the configuration for fcm.credential.private-key");
        }
        if (isBlank(clientEmail)) {
            throw new IllegalArgumentException(
                    "A Client Email is required for Firebase Cloud Messaging (FCM). " +
                            "Please retrieve it from the 'client_email' field in the downloaded Firebase Admin SDK JSON file. " +
                            "Then, input it into the configuration for fcm.credential.client-email");
        }


        Date issuedAt = Date.from(now);
        Date expireAt = Date.from(expiration);
        String token = Jwts.builder()
                .setHeaderParam("kid", privateKeyId)
                .setHeaderParam("typ", "JWT")
                .setIssuer(clientEmail)
                .setSubject(clientEmail)
                .setAudience(FCM_ENDPOINT_URL)
                .setIssuedAt(issuedAt)
                .setExpiration(expireAt)
                .signWith(RSAKeyPairUtil.getPrivateKeyFromString(privateKey), SignatureAlgorithm.RS256)
                .compact();
        return new FcmJwtToken(token, expireAt);
    }

    /**
     * Wraps an {@link FcmJwtToken} instance in a {@link PooledObject}, making it suitable for pooling.
     *
     * @param obj The {@link FcmJwtToken} instance to wrap.
     * @return A {@link PooledObject} wrapping the provided {@link FcmJwtToken}.
     */
    @Override
    public PooledObject<FcmJwtToken> wrap(FcmJwtToken obj) {
        return new DefaultPooledObject<>(obj);
    }

    /**
     * Validates an {@link FcmJwtToken} within a {@link PooledObject}, checking if the token has expired.
     * This ensures that only valid tokens are used for FCM authentication.
     *
     * @param p The {@link PooledObject} containing the {@link FcmJwtToken} to validate.
     * @return true if the token is still valid (not expired), false otherwise.
     */
    @Override
    public boolean validateObject(PooledObject<FcmJwtToken> p) {
        FcmJwtToken object = p.getObject();
        return object.expireAt().after(new Date());
    }
}
