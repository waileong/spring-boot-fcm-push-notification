package io.github.waileong.fcm.service.domain;

/**
 * Defines web push-specific options for messages sent through Firebase Cloud Messaging (FCM).
 * <p>
 * This class includes configuration options for web push messages, such as a URL that should be opened when the user
 * clicks on the notification and an analytics label to segment messages within Firebase Analytics. These options enhance
 * the interaction with and tracking of notifications on web platforms.
 * </p>
 * <p>
 * For more information on web push FCM options, refer to the Firebase documentation:
 * <a href="https://firebase.google.com/docs/reference/fcm/rest/v1/projects.messages#webpushfcmoptions">WebpushFcmOptions</a>
 * </p>
 *
 * @author Wai Leong
 */
public class FcmWebpushFcmOptions {
    private String link;
    private String analyticsLabel;

    /**
     * Retrieves the URL to be opened when the user clicks on the notification.
     *
     * @return The URL associated with the notification.
     */
    public String getLink() {
        return link;
    }

    /**
     * Sets the URL to be opened when the user clicks on the notification.
     *
     * @param link The URL to be associated with the notification.
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * Retrieves the analytics label for the message.
     *
     * @return The analytics label.
     */
    public String getAnalyticsLabel() {
        return analyticsLabel;
    }

    /**
     * Sets the analytics label for the message.
     *
     * @param analyticsLabel The analytics label to set.
     */
    public void setAnalyticsLabel(String analyticsLabel) {
        this.analyticsLabel = analyticsLabel;
    }

    /**
     * Builder class for {@link FcmWebpushFcmOptions}.
     * Provides a fluent interface for constructing {@link FcmWebpushFcmOptions} instances with customized options.
     */
    public static final class Builder {
        private String link;
        private String analyticsLabel;

        private Builder() {
        }

        /**
         * Initiates the creation of a Builder instance for {@link FcmWebpushFcmOptions}.
         *
         * @return A new Builder instance.
         */
        public static Builder aFcmWebpushFcmOptions() {
            return new Builder();
        }

        /**
         * Specifies the URL to be opened when the user clicks on the notification.
         *
         * @param link The URL to be associated with the notification.
         * @return This Builder instance for method chaining.
         */
        public Builder link(String link) {
            this.link = link;
            return this;
        }

        /**
         * Specifies the analytics label for the message.
         *
         * @param analyticsLabel The analytics label for categorizing the message within Firebase Analytics.
         * @return This Builder instance for method chaining.
         */
        public Builder analyticsLabel(String analyticsLabel) {
            this.analyticsLabel = analyticsLabel;
            return this;
        }

        /**
         * Constructs an {@link FcmWebpushFcmOptions} instance with the current configuration.
         *
         * @return A new {@link FcmWebpushFcmOptions} instance.
         */
        public FcmWebpushFcmOptions build() {
            FcmWebpushFcmOptions fcmWebpushFcmOptions = new FcmWebpushFcmOptions();
            fcmWebpushFcmOptions.setLink(link);
            fcmWebpushFcmOptions.setAnalyticsLabel(analyticsLabel);
            return fcmWebpushFcmOptions;
        }
    }
}
