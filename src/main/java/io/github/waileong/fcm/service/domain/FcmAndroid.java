package io.github.waileong.fcm.service.domain;

import java.util.Map;


/**
 * Configuration for sending FCM messages to Android devices.
 * <p>
 * This class encapsulates settings specific to messages intended for Android platforms,
 * such as notification priority, time-to-live (TTL), package name restrictions, and more.
 * It also supports setting custom data payloads and options for the Android notification.
 * </p>
 * <p>
 * For more details on Android message configuration, refer to the Firebase documentation:
 * <a href="https://firebase.google.com/docs/reference/fcm/rest/v1/projects.messages#androidconfig">AndroidConfig</a>
 * </p>
 *
 * @author Wai Leong
 */
public class FcmAndroid {
    private String collapseKey;
    private FcmAndroidMessagePriority priority = FcmAndroidMessagePriority.HIGH;
    private String ttl;
    private String restrictedPackageName;
    private Map<String, String> data;
    private FcmAndroidNotification notification;
    private FcmAndroidFcmOptions fcmOptions;
    private Boolean directBootOk;

    public String getCollapseKey() {
        return collapseKey;
    }

    public void setCollapseKey(String collapseKey) {
        this.collapseKey = collapseKey;
    }

    public FcmAndroidMessagePriority getPriority() {
        return priority;
    }

    public void setPriority(FcmAndroidMessagePriority priority) {
        this.priority = priority;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public String getRestrictedPackageName() {
        return restrictedPackageName;
    }

    public void setRestrictedPackageName(String restrictedPackageName) {
        this.restrictedPackageName = restrictedPackageName;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    public FcmAndroidNotification getNotification() {
        return notification;
    }

    public void setNotification(FcmAndroidNotification notification) {
        this.notification = notification;
    }

    public FcmAndroidFcmOptions getFcmOptions() {
        return fcmOptions;
    }

    public void setFcmOptions(FcmAndroidFcmOptions fcmOptions) {
        this.fcmOptions = fcmOptions;
    }

    public Boolean getDirectBootOk() {
        return directBootOk;
    }

    public void setDirectBootOk(Boolean directBootOk) {
        this.directBootOk = directBootOk;
    }

    /**
     * A builder class for creating {@link FcmAndroid} instances.
     * <p>
     * This builder follows the builder pattern to facilitate the construction of {@link FcmAndroid} instances
     * with various configuration options set. It supports chaining of methods to configure an instance.
     * </p>
     */
    public static final class Builder {
        private String collapseKey;
        private FcmAndroidMessagePriority priority;
        private String ttl;
        private String restrictedPackageName;
        private Map<String, String> data;
        private FcmAndroidNotification notification;
        private FcmAndroidFcmOptions fcmOptions;
        private Boolean directBootOk;

        private Builder() {
        }

        /**
         * Creates a new {@link Builder} instance for constructing an {@link FcmAndroid} object.
         *
         * @return A new {@link Builder} instance.
         */
        public static Builder aFcmAndroid() {
            return new Builder();
        }

        public Builder collapseKey(String collapseKey) {
            this.collapseKey = collapseKey;
            return this;
        }

        public Builder priority(FcmAndroidMessagePriority priority) {
            this.priority = priority;
            return this;
        }

        public Builder ttl(String ttl) {
            this.ttl = ttl;
            return this;
        }

        public Builder restrictedPackageName(String restrictedPackageName) {
            this.restrictedPackageName = restrictedPackageName;
            return this;
        }

        public Builder data(Map<String, String> data) {
            this.data = data;
            return this;
        }

        public Builder notification(FcmAndroidNotification notification) {
            this.notification = notification;
            return this;
        }

        public Builder fcmOptions(FcmAndroidFcmOptions fcmOptions) {
            this.fcmOptions = fcmOptions;
            return this;
        }

        public Builder directBootOk(Boolean directBootOk) {
            this.directBootOk = directBootOk;
            return this;
        }

        /**
         * Builds the configured {@link FcmAndroid} instance.
         *
         * @return An {@link FcmAndroid} instance with the settings applied.
         */
        public FcmAndroid build() {
            FcmAndroid fcmAndroid = new FcmAndroid();
            fcmAndroid.setCollapseKey(collapseKey);
            fcmAndroid.setPriority(priority);
            fcmAndroid.setTtl(ttl);
            fcmAndroid.setRestrictedPackageName(restrictedPackageName);
            fcmAndroid.setData(data);
            fcmAndroid.setNotification(notification);
            fcmAndroid.setFcmOptions(fcmOptions);
            fcmAndroid.setDirectBootOk(directBootOk);
            return fcmAndroid;
        }
    }
}
