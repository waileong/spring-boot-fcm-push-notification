package io.github.waileong.fcm.util;

import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

/**
 * Utility class for handling RSA key operations.
 * <p>
 * Provides functionality to convert a string representation of an RSA private key into its {@link RSAPrivateKey} object form.
 * This is particularly useful when dealing with keys stored in configurations or transmitted in environments where they
 * must be serialized into string format.
 * </p>
 *
 * @author Wai Leong
 */
public class RSAKeyPairUtil {

    /**
     * Converts a base64 encoded string representation of an RSA private key into an {@link RSAPrivateKey} object.
     * <p>
     * The input string is expected to be a PKCS#8 encoded RSA private key in base64 format, with or without the standard
     * PEM header and footer. Newlines within the PEM string are also handled and removed.
     * </p>
     *
     * @param key The base64 encoded string of the PKCS#8 RSA private key, potentially including PEM headers and footers.
     * @return The {@link RSAPrivateKey} object represented by the input string.
     * @throws IllegalArgumentException if the key cannot be parsed, typically due to incorrect formatting or encoding.
     */
    public static RSAPrivateKey getPrivateKeyFromString(String key) {
        try {
            // Remove the standard PEM headers, footers, and any newline characters.
            String privateKeyPEM = key
                    .replace("-----BEGIN PRIVATE KEY-----", "")
                    .replace("-----END PRIVATE KEY-----", "")
                    .replace("\n", "");

            // Decode the base64-encoded string into its byte array representation.
            byte[] encoded = Base64.getDecoder().decode(privateKeyPEM);

            // Create a KeyFactory for RSA keys and generate the private key from its PKCS#8 encoded form.
            KeyFactory kf = KeyFactory.getInstance("RSA");
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encoded);
            return (RSAPrivateKey) kf.generatePrivate(keySpec);
        } catch (Exception ex) {
            // Wrap and rethrow any exceptions as an unchecked exception to avoid forcing calling code to handle.
            throw new IllegalArgumentException("Failed to convert private key from string", ex);
        }
    }
}
