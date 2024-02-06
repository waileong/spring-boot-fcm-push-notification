package io.github.waileong.fcm.service.domain;

import java.util.Map;

/**
 * Configuration for sending a message via Webpush protocol.
 * <p>
 * This class encapsulates settings specific to the Webpush protocol for FCM messages, including HTTP headers,
 * data payloads, and notification options. It allows for detailed configuration of web push notifications,
 * leveraging the capabilities of the Web Notification API.
 * </p>
 * <p>
 * For more details on WebpushConfig, refer to the official Firebase documentation:
 * <a href="https://firebase.google.com/docs/reference/fcm/rest/v1/projects.messages#webpushconfig">WebpushConfig</a>
 * </p>
 *
 * @author Wai Leong
 */
public class FcmWebpush {
    private Map<String, String> headers;
    private Map<String, String> data;
    /**
     * Notification payload, which supports Notification instance properties as defined in the Web Notification API.
     * Fields such as "title" and "body" can override the default values set in the {@link FcmNotification} if specified.
     */
    private String notification;
    private FcmWebpushFcmOptions fcmOptions;

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public FcmWebpushFcmOptions getFcmOptions() {
        return fcmOptions;
    }

    public void setFcmOptions(FcmWebpushFcmOptions fcmOptions) {
        this.fcmOptions = fcmOptions;
    }

    /**
     * Builder class for {@link FcmWebpush}.
     * Provides a fluent interface for constructing {@link FcmWebpush} instances, allowing for detailed configuration.
     */
    public static final class Builder {
        private Map<String, String> headers;
        private Map<String, String> data;
        private String notification;
        private FcmWebpushFcmOptions fcmOptions;

        private Builder() {
        }

        /**
         * Creates a new Builder instance.
         *
         * @return A new instance of Builder for constructing an {@link FcmWebpush}.
         */
        public static Builder aFcmWebpush() {
            return new Builder();
        }

        /**
         * Sets the HTTP headers for the web push notification.
         *
         * @param headers HTTP headers to set.
         * @return This builder instance to facilitate method chaining.
         */
        public Builder headers(Map<String, String> headers) {
            this.headers = headers;
            return this;
        }

        /**
         * Sets the data payload for the web push notification.
         *
         * @param data Data payload to set.
         * @return This builder instance to facilitate method chaining.
         */
        public Builder data(Map<String, String> data) {
            this.data = data;
            return this;
        }

        /**
         * Sets the notification payload, supporting Web Notification API instance properties.
         *
         * @param notification Notification payload to set.
         * @return This builder instance to facilitate method chaining.
         */
        public Builder notification(String notification) {
            this.notification = notification;
            return this;
        }

        /**
         * Sets the FCM options specific to web push notifications.
         *
         * @param fcmOptions FCM options to set.
         * @return This builder instance to facilitate method chaining.
         */
        public Builder fcmOptions(FcmWebpushFcmOptions fcmOptions) {
            this.fcmOptions = fcmOptions;
            return this;
        }

        /**
         * Builds and returns an {@link FcmWebpush} with the configured properties.
         *
         * @return An instance of FcmWebpush.
         */
        public FcmWebpush build() {
            FcmWebpush fcmWebpush = new FcmWebpush();
            fcmWebpush.setHeaders(headers);
            fcmWebpush.setData(data);
            fcmWebpush.setNotification(notification);
            fcmWebpush.setFcmOptions(fcmOptions);
            return fcmWebpush;
        }
    }
}