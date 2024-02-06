package io.github.waileong.fcm.service.domain;

/**
 * Represents the basic structure of a Firebase Cloud Messaging (FCM) notification.
 * <p>
 * This class encapsulates the fundamental attributes of an FCM notification such as the title, body, and image URL.
 * These attributes are used to define the content and appearance of the notification on the client device.
 * </p>
 * <p>
 * For more detailed information on FCM notifications, see the official Firebase documentation:
 * <a href="https://firebase.google.com/docs/reference/fcm/rest/v1/projects.messages#notification">Notification</a>
 * </p>
 *
 * @author Wai Leong
 */
public class FcmNotification {
    private String title;
    private String body;
    private String image;

    /**
     * Gets the title of the notification.
     *
     * @return The notification title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the notification.
     *
     * @param title The notification title.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the body text of the notification.
     *
     * @return The notification body text.
     */
    public String getBody() {
        return body;
    }

    /**
     * Sets the body text of the notification.
     *
     * @param body The notification body text.
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Gets the URL of the image for the notification.
     *
     * @return The URL of the notification image.
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets the URL of the image for the notification.
     *
     * @param image The URL of the notification image.
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Builder class for {@link FcmNotification}.
     * Provides a fluent interface for constructing {@link FcmNotification} instances.
     */
    public static final class Builder {
        private String title;
        private String body;
        private String image;

        private Builder() {
        }

        /**
         * Creates a new Builder instance.
         *
         * @return A new instance of Builder.
         */
        public static Builder aFcmNotification() {
            return new Builder();
        }

        /**
         * Sets the title of the notification.
         *
         * @param title The notification title.
         * @return The builder instance for chaining.
         */
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        /**
         * Sets the body text of the notification.
         *
         * @param body The notification body text.
         * @return The builder instance for chaining.
         */
        public Builder body(String body) {
            this.body = body;
            return this;
        }

        /**
         * Sets the URL of the image for the notification.
         *
         * @param image The URL of the notification image.
         * @return The builder instance for chaining.
         */
        public Builder image(String image) {
            this.image = image;
            return this;
        }

        /**
         * Builds and returns an {@link FcmNotification} with the configured properties.
         *
         * @return An instance of FcmNotification.
         */
        public FcmNotification build() {
            FcmNotification fcmNotification = new FcmNotification();
            fcmNotification.setTitle(title);
            fcmNotification.setBody(body);
            fcmNotification.setImage(image);
            return fcmNotification;
        }
    }
}
