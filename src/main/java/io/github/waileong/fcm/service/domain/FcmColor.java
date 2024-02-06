package io.github.waileong.fcm.service.domain;

/**
 * Represents a color in the FCM message payload.
 * <p>
 * This class encapsulates the color as RGBA (Red, Green, Blue, Alpha) values,
 * where each component is represented as a float value. The Alpha component specifies the color's opacity.
 * </p>
 * <p>
 * For more details on how to specify color in FCM messages, refer to the Firebase documentation:
 * <a href="https://firebase.google.com/docs/reference/fcm/rest/v1/projects.messages#color">Color</a>
 * </p>
 *
 * @author Wai Leong
 */
public class FcmColor {
    private float red;
    private float green;
    private float blue;
    private float alpha;

    /**
     * Gets the red component of the color.
     *
     * @return the red component value
     */
    public float getRed() {
        return red;
    }

    /**
     * Sets the red component of the color.
     *
     * @param red the red component value
     */
    public void setRed(float red) {
        this.red = red;
    }

    /**
     * Gets the green component of the color.
     *
     * @return the green component value
     */
    public float getGreen() {
        return green;
    }

    /**
     * Sets the green component of the color.
     *
     * @param green the green component value
     */
    public void setGreen(float green) {
        this.green = green;
    }

    /**
     * Gets the blue component of the color.
     *
     * @return the blue component value
     */
    public float getBlue() {
        return blue;
    }

    /**
     * Sets the blue component of the color.
     *
     * @param blue the blue component value
     */
    public void setBlue(float blue) {
        this.blue = blue;
    }

    /**
     * Gets the alpha (opacity) component of the color.
     *
     * @return the alpha component value
     */
    public float getAlpha() {
        return alpha;
    }

    /**
     * Sets the alpha (opacity) component of the color.
     *
     * @param alpha the alpha component value
     */
    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    /**
     * Builder class for {@link FcmColor}. Provides a fluent interface for constructing {@link FcmColor} instances.
     */
    public static final class Builder {
        private float red;
        private float green;
        private float blue;
        private float alpha;

        private Builder() {
        }

        /**
         * Creates a new Builder instance.
         *
         * @return a new instance of Builder.
         */
        public static Builder aFcmColor() {
            return new Builder();
        }

        /**
         * Sets the red component of the color.
         *
         * @param red the red component value
         * @return the builder instance
         */
        public Builder red(float red) {
            this.red = red;
            return this;
        }

        /**
         * Sets the green component of the color.
         *
         * @param green the green component value
         * @return the builder instance
         */
        public Builder green(float green) {
            this.green = green;
            return this;
        }

        /**
         * Sets the blue component of the color.
         *
         * @param blue the blue component value
         * @return the builder instance
         */
        public Builder blue(float blue) {
            this.blue = blue;
            return this;
        }

        /**
         * Sets the alpha (opacity) component of the color.
         *
         * @param alpha the alpha component value
         * @return the builder instance
         */
        public Builder alpha(float alpha) {
            this.alpha = alpha;
            return this;
        }

        /**
         * Builds and returns a {@link FcmColor} with the current configuration of this builder.
         *
         * @return a new instance of FcmColor.
         */
        public FcmColor build() {
            FcmColor fcmColor = new FcmColor();
            fcmColor.setRed(red);
            fcmColor.setGreen(green);
            fcmColor.setBlue(blue);
            fcmColor.setAlpha(alpha);
            return fcmColor;
        }
    }
}
