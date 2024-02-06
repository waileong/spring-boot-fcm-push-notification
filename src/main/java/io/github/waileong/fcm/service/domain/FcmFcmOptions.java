package io.github.waileong.fcm.service.domain;

/**
 * Represents FCM-specific options that can be included in a message sent through Firebase Cloud Messaging.
 * <p>
 * Currently, this class supports setting an {@code analyticsLabel}, which is used for categorizing messages within
 * Firebase Analytics. This allows for the aggregation and analysis of message delivery data based on custom
 * labels assigned to each message.
 * </p>
 * <p>
 * Refer to the Firebase documentation for more details on FCM options:
 * <a href="https://firebase.google.com/docs/reference/fcm/rest/v1/projects.messages#fcmoptions">FcmOptions</a>
 * </p>
 *
 * @author Wai Leong
 */
public class FcmFcmOptions {
    private String analyticsLabel;

    /**
     * Retrieves the analytics label associated with the FCM message.
     *
     * @return The analytics label used for categorizing the message within Firebase Analytics.
     */
    public String getAnalyticsLabel() {
        return analyticsLabel;
    }

    /**
     * Sets the analytics label for the FCM message.
     *
     * @param analyticsLabel The analytics label to be used for categorizing the message within Firebase Analytics.
     */
    public void setAnalyticsLabel(String analyticsLabel) {
        this.analyticsLabel = analyticsLabel;
    }

    /**
     * Builder class for {@link FcmFcmOptions}.
     * Provides a fluent interface for constructing {@link FcmFcmOptions} instances with specified analytics labels.
     */
    public static final class Builder {
        private String analyticsLabel;

        private Builder() {
        }

        /**
         * Initiates the creation of a Builder instance for {@link FcmFcmOptions}.
         *
         * @return A new Builder instance.
         */
        public static Builder aFcmFcmOptions() {
            return new Builder();
        }

        /**
         * Specifies the analytics label for the FCM message.
         *
         * @param analyticsLabel The analytics label to use for the message.
         * @return This Builder instance for method chaining.
         */
        public Builder analyticsLabel(String analyticsLabel) {
            this.analyticsLabel = analyticsLabel;
            return this;
        }

        /**
         * Builds and returns an {@link FcmFcmOptions} instance with the configured analytics label.
         *
         * @return A new {@link FcmFcmOptions} instance.
         */
        public FcmFcmOptions build() {
            FcmFcmOptions fcmFcmOptions = new FcmFcmOptions();
            fcmFcmOptions.setAnalyticsLabel(analyticsLabel);
            return fcmFcmOptions;
        }
    }
}
