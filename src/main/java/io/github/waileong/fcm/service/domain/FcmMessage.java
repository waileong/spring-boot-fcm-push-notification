package io.github.waileong.fcm.service.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Map;


/**
 * Represents a Firebase Cloud Messaging (FCM) message that can be sent to a client app.
 * This class encapsulates various FCM message options such as data payload, notification details,
 * and platform-specific configurations (Android, Webpush, APNs).
 * <p>
 * Instances of this class can be constructed using the nested {@link Builder} class.
 * </p>
 * <p>
 * For more details on Android message configuration, refer to the Firebase documentation:
 * <a href="https://firebase.google.com/docs/reference/fcm/rest/v1/projects.messages#resource:-message">Message</a>
 * </p>
 *
 * @author Wai Leong
 */
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FcmMessage {
    private String name;
    private Map<String, String> data;
    private FcmNotification notification;
    private FcmAndroid android;
    private FcmWebpush webpush;
    private FcmApns apns;
    private FcmFcmOptions fcmOptions;
    private String token;
    private String topic;
    private String condition;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    public FcmNotification getNotification() {
        return notification;
    }

    public void setNotification(FcmNotification notification) {
        this.notification = notification;
    }

    public FcmAndroid getAndroid() {
        return android;
    }

    public void setAndroid(FcmAndroid android) {
        this.android = android;
    }

    public FcmWebpush getWebpush() {
        return webpush;
    }

    public void setWebpush(FcmWebpush webpush) {
        this.webpush = webpush;
    }

    public FcmApns getApns() {
        return apns;
    }

    public void setApns(FcmApns apns) {
        this.apns = apns;
    }

    public FcmFcmOptions getFcmOptions() {
        return fcmOptions;
    }

    public void setFcmOptions(FcmFcmOptions fcmOptions) {
        this.fcmOptions = fcmOptions;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    /**
     * Builder class for {@link FcmMessage}. Provides a fluent interface for constructing instances of FcmMessage.
     */
    public static final class Builder {
        private String name;
        private Map<String, String> data;
        private FcmNotification notification;
        private FcmAndroid android;
        private FcmWebpush webpush;
        private FcmApns apns;
        private FcmFcmOptions fcmOptions;
        private String token;
        private String topic;
        private String condition;

        private Builder() {
        }

        /**
         * Creates a new Builder instance.
         *
         * @return a new instance of Builder.
         */
        public static Builder aFcmMessage() {
            return new Builder();
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder data(Map<String, String> data) {
            this.data = data;
            return this;
        }

        public Builder notification(FcmNotification notification) {
            this.notification = notification;
            return this;
        }

        public Builder android(FcmAndroid android) {
            this.android = android;
            return this;
        }

        public Builder webpush(FcmWebpush webpush) {
            this.webpush = webpush;
            return this;
        }

        public Builder apns(FcmApns apns) {
            this.apns = apns;
            return this;
        }

        public Builder fcmOptions(FcmFcmOptions fcmOptions) {
            this.fcmOptions = fcmOptions;
            return this;
        }

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public Builder topic(String topic) {
            this.topic = topic;
            return this;
        }

        public Builder condition(String condition) {
            this.condition = condition;
            return this;
        }

        /**
         * Builds and returns a {@link FcmMessage} with the current configuration of this builder.
         *
         * @return a new instance of FcmMessage.
         */
        public FcmMessage build() {
            FcmMessage fcmMessage = new FcmMessage();
            fcmMessage.setName(name);
            fcmMessage.setData(data);
            fcmMessage.setNotification(notification);
            fcmMessage.setAndroid(android);
            fcmMessage.setWebpush(webpush);
            fcmMessage.setApns(apns);
            fcmMessage.setFcmOptions(fcmOptions);
            fcmMessage.setToken(token);
            fcmMessage.setTopic(topic);
            fcmMessage.setCondition(condition);
            return fcmMessage;
        }
    }
}
