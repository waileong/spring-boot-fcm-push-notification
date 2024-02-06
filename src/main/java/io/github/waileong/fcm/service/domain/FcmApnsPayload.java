package io.github.waileong.fcm.service.domain;

/**
 * Represents the payload of an APNs message for use with Firebase Cloud Messaging (FCM).
 * <p>
 * The {@code aps} dictionary is a required part of any APNs payload and contains the information used by iOS
 * and macOS to deliver and present the notification to the user. This includes the alert message, badge count,
 * sound, and other notification behavior settings.
 * </p>
 * <p>
 * This class provides a structured way to construct the APNs payload, ensuring that the necessary fields
 * are included and correctly formatted according to APNs requirements.
 * </p>
 *
 * @author Wai Leong
 */
public class FcmApnsPayload {
    private FcmApnsAps aps;

    /**
     * Gets the {@code aps} dictionary of the APNs payload.
     *
     * @return The {@code aps} dictionary, which controls how the notification is displayed and handled.
     */
    public FcmApnsAps getAps() {
        return aps;
    }

    /**
     * Sets the {@code aps} dictionary of the APNs payload.
     *
     * @param aps The {@code aps} dictionary to set, detailing the notification's display and behavior.
     */
    public void setAps(FcmApnsAps aps) {
        this.aps = aps;
    }

    /**
     * Builder class for {@link FcmApnsPayload}.
     * Provides a fluent interface for constructing an {@link FcmApnsPayload} instance with a specified {@code aps} dictionary.
     */
    public static final class Builder {
        private FcmApnsAps aps;

        private Builder() {
        }

        /**
         * Initiates the creation of a Builder instance for {@link FcmApnsPayload}.
         *
         * @return A new Builder instance.
         */
        public static Builder aFcmApnsPayload() {
            return new Builder();
        }

        /**
         * Specifies the {@code aps} dictionary for the APNs payload.
         *
         * @param aps The {@code aps} dictionary detailing the notification's display and behavior.
         * @return This Builder instance for method chaining.
         */
        public Builder aps(FcmApnsAps aps) {
            this.aps = aps;
            return this;
        }

        /**
         * Builds and returns an {@link FcmApnsPayload} instance with the configured {@code aps} dictionary.
         *
         * @return A new {@link FcmApnsPayload} instance.
         */
        public FcmApnsPayload build() {
            FcmApnsPayload fcmApnsPayload = new FcmApnsPayload();
            fcmApnsPayload.setAps(aps);
            return fcmApnsPayload;
        }
    }
}
