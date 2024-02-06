package io.github.waileong.fcm.service.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotNull;

/**
 * Represents the request body for sending a message through Firebase Cloud Messaging (FCM).
 * <p>
 * This class is structured to include all necessary information for an FCM send message request. The {@code validateOnly} flag
 * indicates whether the message should be validated without actually being sent, useful for testing. The {@code message} field
 * contains the message payload, including target information and options.
 * </p>
 * <p>
 * The class uses {@link JsonNaming} with {@link PropertyNamingStrategies.SnakeCaseStrategy} to ensure JSON fields are
 * properly mapped to and from snake_case as expected by the FCM REST API.
 * </p>
 * <p>
 * For detailed information on the FCM send message request, refer to the official documentation:
 * <a href="https://firebase.google.com/docs/reference/fcm/rest/v1/projects.messages/send#request-body">Sending an FCM message</a>
 * </p>
 *
 * @author Wai Leong
 */
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FcmSendRequest {
    private Boolean validateOnly;
    @NotNull
    private FcmMessage message;

    /**
     * Gets whether the message should be validated only.
     *
     * @return {@code true} if the request should only validate the message without sending it, {@code false} otherwise.
     */
    public Boolean getValidateOnly() {
        return validateOnly;
    }

    /**
     * Sets whether the message should be validated only.
     *
     * @param validateOnly {@code true} to only validate the message without sending it, {@code false} to send the message.
     */
    public void setValidateOnly(Boolean validateOnly) {
        this.validateOnly = validateOnly;
    }

    /**
     * Gets the message to be sent or validated.
     *
     * @return The message.
     */
    public FcmMessage getMessage() {
        return message;
    }

    /**
     * Sets the message to be sent or validated.
     *
     * @param message The message.
     */
    public void setMessage(FcmMessage message) {
        this.message = message;
    }

    /**
     * Builder class for {@link FcmSendRequest}.
     * Provides a fluent interface for constructing an {@link FcmSendRequest} instance.
     */
    public static final class Builder {
        private Boolean validateOnly;
        private FcmMessage message;

        private Builder() {
        }

        /**
         * Initiates the creation of a Builder instance for {@link FcmSendRequest}.
         *
         * @return A new Builder instance.
         */
        public static Builder aFcmSendRequest() {
            return new Builder();
        }

        /**
         * Specifies whether the message should be validated only.
         *
         * @param validateOnly {@code true} to only validate the message without sending it, {@code false} to send the message.
         * @return This Builder instance for method chaining.
         */
        public Builder validateOnly(Boolean validateOnly) {
            this.validateOnly = validateOnly;
            return this;
        }

        /**
         * Specifies the message to be sent or validated.
         *
         * @param message The message.
         * @return This Builder instance for method chaining.
         */
        public Builder message(FcmMessage message) {
            this.message = message;
            return this;
        }

        /**
         * Builds and returns an {@link FcmSendRequest} instance with the configured properties.
         *
         * @return A new {@link FcmSendRequest} instance.
         */
        public FcmSendRequest build() {
            FcmSendRequest fcmSendRequest = new FcmSendRequest();
            fcmSendRequest.setValidateOnly(validateOnly);
            fcmSendRequest.setMessage(message);
            return fcmSendRequest;
        }
    }
}
