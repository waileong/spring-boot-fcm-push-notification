package io.github.waileong.fcm.service.domain;

/**
 * Represents the light settings for an FCM notification on Android devices.
 * <p>
 * This class encapsulates the configuration for the device's notification LED color, as well as the on and off
 * durations for the light pattern. The color is defined by an {@link FcmColor} instance.
 * </p>
 * <p>
 * For more details on light settings in FCM messages, refer to the Firebase documentation:
 * <a href="https://firebase.google.com/docs/reference/fcm/rest/v1/projects.messages#lightsettings">LightSettings</a>
 * </p>
 *
 * @author Wai Leong
 */
public class FcmLightSettings {
    private FcmColor color;
    private String lightOnDuration;
    private String lightOffDuration;

    /**
     * Gets the color of the light.
     *
     * @return The color of the notification light.
     */
    public FcmColor getColor() {
        return color;
    }

    /**
     * Sets the color of the light.
     *
     * @param color The color to be used for the notification light.
     */
    public void setColor(FcmColor color) {
        this.color = color;
    }

    /**
     * Gets the duration for which the light is on.
     *
     * @return The duration the light stays on.
     */
    public String getLightOnDuration() {
        return lightOnDuration;
    }

    /**
     * Sets the duration for which the light is on.
     *
     * @param lightOnDuration The duration the light will stay on.
     */
    public void setLightOnDuration(String lightOnDuration) {
        this.lightOnDuration = lightOnDuration;
    }

    /**
     * Gets the duration for which the light is off.
     *
     * @return The duration the light stays off.
     */
    public String getLightOffDuration() {
        return lightOffDuration;
    }

    /**
     * Sets the duration for which the light is off.
     *
     * @param lightOffDuration The duration the light will stay off.
     */
    public void setLightOffDuration(String lightOffDuration) {
        this.lightOffDuration = lightOffDuration;
    }

    /**
     * Builder class for {@link FcmLightSettings}. Provides a fluent interface for constructing {@link FcmLightSettings} instances.
     */
    public static final class Builder {
        private FcmColor color;
        private String lightOnDuration;
        private String lightOffDuration;

        private Builder() {
        }

        /**
         * Creates a new Builder instance.
         *
         * @return a new instance of Builder.
         */
        public static Builder aFcmLightSettings() {
            return new Builder();
        }

        /**
         * Sets the color of the light.
         *
         * @param color The color to be used for the notification light.
         * @return the builder instance
         */
        public Builder color(FcmColor color) {
            this.color = color;
            return this;
        }

        /**
         * Sets the duration for which the light is on.
         *
         * @param lightOnDuration The duration the light will stay on.
         * @return the builder instance
         */
        public Builder lightOnDuration(String lightOnDuration) {
            this.lightOnDuration = lightOnDuration;
            return this;
        }

        /**
         * Sets the duration for which the light is off.
         *
         * @param lightOffDuration The duration the light will stay off.
         * @return the builder instance
         */
        public Builder lightOffDuration(String lightOffDuration) {
            this.lightOffDuration = lightOffDuration;
            return this;
        }

        /**
         * Builds and returns a {@link FcmLightSettings} with the current configuration of this builder.
         *
         * @return a new instance of FcmLightSettings.
         */
        public FcmLightSettings build() {
            FcmLightSettings fcmLightSettings = new FcmLightSettings();
            fcmLightSettings.setColor(color);
            fcmLightSettings.setLightOnDuration(lightOnDuration);
            fcmLightSettings.setLightOffDuration(lightOffDuration);
            return fcmLightSettings;
        }
    }
}
