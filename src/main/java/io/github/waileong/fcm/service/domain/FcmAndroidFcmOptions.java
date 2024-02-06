package io.github.waileong.fcm.service.domain;

/**
 * Defines Android-specific options for messages sent through Firebase Cloud Messaging (FCM).
 * <p>
 * This class provides the ability to specify an analytics label for the message. The analytics label is used
 * to segment messages within Firebase Analytics, allowing for detailed analysis and reporting.
 * </p>
 * <p>
 * For detailed information on Android FCM options, including the analytics label, refer to the official Firebase documentation:
 * <a href="https://firebase.google.com/docs/reference/fcm/rest/v1/projects.messages#androidfcmoptions">AndroidFcmOptions</a>
 * </p>
 *
 * @author Wai Leong
 */
public class FcmAndroidFcmOptions {
    private String analyticsLabel;

    /**
     * Retrieves the analytics label associated with this message.
     *
     * @return The analytics label.
     */
    public String getAnalyticsLabel() {
        return analyticsLabel;
    }

    /**
     * Sets the analytics label for this message.
     *
     * @param analyticsLabel The analytics label to set.
     */
    public void setAnalyticsLabel(String analyticsLabel) {
        this.analyticsLabel = analyticsLabel;
    }

    /**
     * Builder class for {@link FcmAndroidFcmOptions}.
     * Provides a fluent interface for constructing {@link FcmAndroidFcmOptions} instances with a specific analytics label.
     */
    public static final class Builder {
        private String analyticsLabel;

        private Builder() {
        }

        /**
         * Initiates the creation of a new {@link FcmAndroidFcmOptions} instance.
         *
         * @return A new {@code Builder} instance.
         */
        public static Builder aFcmAndroidFcmOptions() {
            return new Builder();
        }

        /**
         * Specifies the analytics label for the message.
         *
         * @param analyticsLabel The analytics label to use.
         * @return This builder instance to facilitate method chaining.
         */
        public Builder analyticsLabel(String analyticsLabel) {
            this.analyticsLabel = analyticsLabel;
            return this;
        }

        /**
         * Constructs a new {@link FcmAndroidFcmOptions} instance with the current configuration.
         *
         * @return A new {@link FcmAndroidFcmOptions} instance.
         */
        public FcmAndroidFcmOptions build() {
            FcmAndroidFcmOptions fcmAndroidFcmOptions = new FcmAndroidFcmOptions();
            fcmAndroidFcmOptions.setAnalyticsLabel(analyticsLabel);
            return fcmAndroidFcmOptions;
        }
    }
}
