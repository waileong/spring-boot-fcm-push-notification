package io.github.waileong.fcm.service.domain;

import java.util.Map;

/**
 * Represents the Apple Push Notification service (APNs) configuration for an FCM message.
 * <p>
 * This class encapsulates the APNs-specific configuration data for a message, including HTTP headers, the payload,
 * and APNs-specific options. The {@code headers} map allows for specifying HTTP header fields such as {@code apns-priority},
 * {@code apns-expiration}, etc. The {@code payload} contains the notification's content and behavior details,
 * and {@code fcmOptions} allows for setting APNs-specific message options like {@code analyticsLabel} and {@code image}.
 * </p>
 * <p>
 * For more details on APNs configuration in FCM messages, refer to the Firebase documentation:
 * <a href="https://firebase.google.com/docs/reference/fcm/rest/v1/projects.messages#apnsconfig">APNs Config in FCM</a>
 * </p>
 *
 * @author Wai Leong
 */
public class FcmApns {
    private Map<String, String> headers;
    private FcmApnsPayload payload;
    private FcmApnsOptions fcmOptions;

    /**
     * Gets the HTTP headers for the APNs message.
     *
     * @return A map of HTTP header fields for the message.
     */
    public Map<String, String> getHeaders() {
        return headers;
    }

    /**
     * Sets the HTTP headers for the APNs message.
     *
     * @param headers A map of HTTP header fields for the message.
     */
    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    /**
     * Gets the payload for the APNs message.
     *
     * @return The payload of the APNs message.
     */
    public FcmApnsPayload getPayload() {
        return payload;
    }

    /**
     * Sets the payload for the APNs message.
     *
     * @param payload The payload of the APNs message.
     */
    public void setPayload(FcmApnsPayload payload) {
        this.payload = payload;
    }

    /**
     * Gets the APNs options for the FCM message.
     *
     * @return The APNs options.
     */
    public FcmApnsOptions getFcmOptions() {
        return fcmOptions;
    }

    /**
     * Sets the APNs options for the FCM message.
     *
     * @param fcmOptions The APNs options to set.
     */
    public void setFcmOptions(FcmApnsOptions fcmOptions) {
        this.fcmOptions = fcmOptions;
    }

    /**
     * Builder class for {@link FcmApns}.
     * Provides a fluent interface for constructing an {@link FcmApns} instance with specified headers, payload, and options.
     */
    public static final class Builder {
        private Map<String, String> headers;
        private FcmApnsPayload payload;
        private FcmApnsOptions fcmOptions;

        private Builder() {
        }

        /**
         * Creates a new Builder instance.
         *
         * @return A new instance of Builder.
         */
        public static Builder aFcmApns() {
            return new Builder();
        }

        /**
         * Specifies the HTTP headers for the APNs message.
         *
         * @param headers The HTTP headers to set.
         * @return This Builder instance for method chaining.
         */
        public Builder headers(Map<String, String> headers) {
            this.headers = headers;
            return this;
        }

        /**
         * Specifies the payload for the APNs message.
         *
         * @param payload The payload to set.
         * @return This Builder instance for method chaining.
         */
        public Builder payload(FcmApnsPayload payload) {
            this.payload = payload;
            return this;
        }

        /**
         * Specifies the APNs options for the FCM message.
         *
         * @param fcmOptions The APNs options to set.
         * @return This Builder instance for method chaining.
         */
        public Builder fcmOptions(FcmApnsOptions fcmOptions) {
            this.fcmOptions = fcmOptions;
            return this;
        }

        /**
         * Builds and returns an {@link FcmApns} instance with the configured properties.
         *
         * @return A new {@link FcmApns} instance.
         */
        public FcmApns build() {
            FcmApns fcmApns = new FcmApns();
            fcmApns.setHeaders(headers);
            fcmApns.setPayload(payload);
            fcmApns.setFcmOptions(fcmOptions);
            return fcmApns;
        }
    }
}
