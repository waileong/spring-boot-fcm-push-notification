package io.github.waileong.fcm.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.client.JdkClientHttpRequestFactory;

import javax.net.ssl.SSLContext;
import java.net.http.HttpClient;
import java.time.Duration;

/**
 * Configuration properties class for Firebase Cloud Messaging (FCM) integration.
 * <p>
 * This class facilitates the externalization of configuration properties related to FCM, specifically focusing on
 * service account credentials, HTTP client connection settings, and settings for JWT token pool management.
 * It enables easy and flexible configuration of these properties through application properties files, enhancing
 * the security and efficiency of FCM service authentication and communication.
 * </p>
 *
 * <p>
 * Usage example in application.properties:
 * <pre>
 * fcm.credential.projectId=your-fcm-project-id
 * fcm.credential.privateKeyId=your-private-key-id
 * fcm.credential.privateKey=your-private-key
 * fcm.credential.clientEmail=your-client-email
 * fcm.connection.connectTimeout=PT10S
 * fcm.connection.readTimeout=PT30S
 * fcm.jwtTokenPoolSetting.maxTotal=20
 * fcm.jwtTokenPoolSetting.maxIdle=10
 * </pre>
 *
 * @author Wai Leong
 */
@ConfigurationProperties(prefix = "fcm")
public class FcmProperties {

    /**
     * Connection settings for the HTTP client used to send requests to FCM.
     */
    private final ConnectionSetting connection = new ConnectionSetting();
    /**
     * Service account credentials for authenticating with Firebase services.
     */
    private final Credential credential = new Credential();

    /**
     * Settings for managing the JWT token pool used in FCM authentication.
     */
    private final JwtTokenPoolSetting jwtTokenPoolSetting = new JwtTokenPoolSetting();


    /**
     * Gets the connection settings for FCM.
     *
     * @return the connection settings
     */
    public ConnectionSetting getConnection() {
        return connection;
    }

    /**
     * Gets the service account credentials for FCM.
     *
     * @return the service account credentials
     */
    public Credential getCredential() {
        return credential;
    }

    /**
     * Gets the JWT token pool settings for FCM.
     *
     * @return the JWT token pool settings
     */
    public JwtTokenPoolSetting getJwtTokenPoolSetting() {
        return jwtTokenPoolSetting;
    }

    /**
     * Inner class to encapsulate connection settings for HTTP client used with FCM.
     */
    public static class ConnectionSetting {
        /**
         * Connect timeout duration for {@code HttpClient}.
         *
         * @see HttpClient.Builder#connectTimeout(Duration)
         */
        private Duration connectTimeout;

        /**
         * Read timeout duration for the underlying HTTP client.
         *
         * @see JdkClientHttpRequestFactory#setReadTimeout(Duration)
         */
        private Duration readTimeout;

        /**
         * SSL bundle name for setting up SSL context in {@code HttpClient}.
         *
         * @see HttpClient.Builder#sslContext(SSLContext)
         */
        private String sslBundleName;

        /**
         * Gets the connect timeout duration.
         *
         * @return the connect timeout duration
         */
        public Duration getConnectTimeout() {
            return connectTimeout;
        }

        /**
         * Sets the connect timeout duration.
         *
         * @param connectTimeout the connect timeout duration to set
         */
        public void setConnectTimeout(Duration connectTimeout) {
            this.connectTimeout = connectTimeout;
        }

        /**
         * Gets the read timeout duration.
         *
         * @return the read timeout duration
         */
        public Duration getReadTimeout() {
            return readTimeout;
        }

        /**
         * Sets the read timeout duration.
         *
         * @param readTimeout the read timeout duration to set
         */
        public void setReadTimeout(Duration readTimeout) {
            this.readTimeout = readTimeout;
        }

        /**
         * Gets the SSL bundle name.
         *
         * @return the SSL bundle name
         */
        public String getSslBundleName() {
            return sslBundleName;
        }

        /**
         * Sets the SSL bundle name.
         *
         * @param sslBundleName the SSL bundle name to set
         */
        public void setSslBundleName(String sslBundleName) {
            this.sslBundleName = sslBundleName;
        }
    }

    /**
     * Represents the credentials needed for Firebase Cloud Messaging (FCM) service account authentication.
     * <p>
     * This class holds the necessary details extracted from the Firebase service account JSON file, which are required
     * to authenticate with Firebase services. These details include the project ID, private key ID, private key,
     * and client email associated with the Firebase service account.
     * </p>
     * <p>
     * These credentials are crucial for initializing the SDK in environments outside of Google Cloud, enabling
     * the application to interact securely with Firebase services.
     * </p>
     * <p>
     * More information on setting up a Firebase service account and obtaining these credentials can be found in the
     * Firebase documentation: <a href="https://firebase.google.com/docs/admin/setup#initialize_the_sdk_in_non-google_environments">
     * Initialize the SDK</a>.
     * </p>
     */
    public static class Credential {
        /**
         * The project ID associated with the Firebase service account.
         */
        private String projectId;

        /**
         * The private key ID from the Firebase service account JSON file.
         */
        private String privateKeyId;

        /**
         * The private key from the Firebase service account JSON file, necessary for authentication.
         */
        private String privateKey;

        /**
         * The client email associated with the Firebase service account, used for authentication.
         */
        private String clientEmail;

        /**
         * Gets the project ID of the Firebase service account.
         *
         * @return The project ID.
         */
        public String getProjectId() {
            return projectId;
        }

        /**
         * Sets the project ID for the Firebase service account.
         *
         * @param projectId The project ID to set.
         */
        public void setProjectId(String projectId) {
            this.projectId = projectId;
        }

        /**
         * Gets the private key ID of the Firebase service account.
         *
         * @return The private key ID.
         */
        public String getPrivateKeyId() {
            return privateKeyId;
        }

        /**
         * Sets the private key ID for the Firebase service account.
         *
         * @param privateKeyId The private key ID to set.
         */
        public void setPrivateKeyId(String privateKeyId) {
            this.privateKeyId = privateKeyId;
        }

        /**
         * Gets the private key of the Firebase service account.
         *
         * @return The private key.
         */
        public String getPrivateKey() {
            return privateKey;
        }

        /**
         * Sets the private key for the Firebase service account.
         *
         * @param privateKey The private key to set.
         */
        public void setPrivateKey(String privateKey) {
            this.privateKey = privateKey;
        }

        /**
         * Gets the client email of the Firebase service account.
         *
         * @return The client email.
         */
        public String getClientEmail() {
            return clientEmail;
        }

        /**
         * Sets the client email for the Firebase service account.
         *
         * @param clientEmail The client email to set.
         */
        public void setClientEmail(String clientEmail) {
            this.clientEmail = clientEmail;
        }
    }

    /**
     * Configuration settings for managing the pool of JWT tokens used in FCM authentication.
     */
    public static class JwtTokenPoolSetting {
        /**
         * Max total number of JWT tokens in the pool.
         */
        private int maxTotal = 20;
        /**
         * Max number of idle JWT tokens in the pool.
         */
        private int maxIdle = 20;

        public int getMaxTotal() {
            return maxTotal;
        }

        public void setMaxTotal(int maxTotal) {
            this.maxTotal = maxTotal;
        }

        public int getMaxIdle() {
            return maxIdle;
        }

        public void setMaxIdle(int maxIdle) {
            this.maxIdle = maxIdle;
        }
    }
}
