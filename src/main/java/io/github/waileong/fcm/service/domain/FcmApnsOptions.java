package io.github.waileong.fcm.service.domain;

/**
 * Represents the APNs-specific options for a message sent through Firebase Cloud Messaging (FCM).
 * <p>
 * This class allows for the specification of options such as {@code analyticsLabel} for analytics tracking
 * and {@code image} for including an image URL in the notification payload. These options enhance the delivery
 * and presentation of notifications on Apple devices.
 * </p>
 * <p>
 * See Firebase documentation for more details on APNs FCM options:
 * <a href="https://firebase.google.com/docs/reference/fcm/rest/v1/projects.messages#apnsfcmoptions">APNs FCM Options</a>
 * </p>
 *
 * @author Wai Leong
 */
public class FcmApnsOptions {
    private String analyticsLabel;
    private String image;

    /**
     * Gets the analytics label used for categorizing messages within Firebase Analytics.
     *
     * @return The analytics label.
     */
    public String getAnalyticsLabel() {
        return analyticsLabel;
    }

    /**
     * Sets the analytics label used for categorizing messages within Firebase Analytics.
     *
     * @param analyticsLabel The analytics label to set.
     */
    public void setAnalyticsLabel(String analyticsLabel) {
        this.analyticsLabel = analyticsLabel;
    }

    /**
     * Gets the URL of the image to be included in the notification.
     *
     * @return The URL of the image.
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets the URL of the image to be included in the notification.
     *
     * @param image The URL of the image to set.
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Builder class for {@link FcmApnsOptions}.
     * Provides a fluent interface for constructing {@link FcmApnsOptions} instances with specified analytics label and image URL.
     */
    public static final class Builder {
        private String analyticsLabel;
        private String image;

        private Builder() {
        }

        /**
         * Initiates the creation of a Builder instance for {@link FcmApnsOptions}.
         *
         * @return A new Builder instance.
         */
        public static Builder aFcmApnsOptions() {
            return new Builder();
        }

        /**
         * Specifies the analytics label for the message.
         *
         * @param analyticsLabel The analytics label for the message.
         * @return This Builder instance for method chaining.
         */
        public Builder analyticsLabel(String analyticsLabel) {
            this.analyticsLabel = analyticsLabel;
            return this;
        }

        /**
         * Specifies the URL of the image to be included in the notification.
         *
         * @param image The URL of the image.
         * @return This Builder instance for method chaining.
         */
        public Builder image(String image) {
            this.image = image;
            return this;
        }

        /**
         * Constructs an {@link FcmApnsOptions} instance with the current configuration.
         *
         * @return A new {@link FcmApnsOptions} instance.
         */
        public FcmApnsOptions build() {
            FcmApnsOptions fcmApnsOptions = new FcmApnsOptions();
            fcmApnsOptions.setAnalyticsLabel(analyticsLabel);
            fcmApnsOptions.setImage(image);
            return fcmApnsOptions;
        }
    }
}
