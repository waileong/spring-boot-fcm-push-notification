package io.github.waileong.fcm.exception;

import io.github.waileong.fcm.service.domain.FcmError;

/**
 * Custom exception type for errors encountered when interacting with Firebase Cloud Messaging (FCM) through a REST client.
 * <p>
 * This exception class encapsulates additional details about the error, including the HTTP status code of the failed request
 * and an {@link FcmError} object containing detailed error information from FCM. It can also be constructed with a simple
 * error message for cases where detailed FCM error information is not available.
 * </p>
 *
 * @author Wai Leong
 */
public class FcmRestClientException extends RuntimeException {
    private final int httpStatus;
    private final FcmError error;

    /**
     * Constructs a new FcmRestClientException with specified HTTP status code and FCM error details.
     *
     * @param httpStatus The HTTP status code associated with the REST client error.
     * @param error      The {@link FcmError} object containing detailed information about the FCM error.
     */
    public FcmRestClientException(int httpStatus, FcmError error) {
        this.httpStatus = httpStatus;
        this.error = error;
    }

    /**
     * Constructs a new FcmRestClientException with specified HTTP status code and error message.
     *
     * @param httpStatus The HTTP status code associated with the REST client error.
     * @param message    The error message describing the nature of the error.
     */
    public FcmRestClientException(int httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
        this.error = null;
    }

    /**
     * Gets the HTTP status code associated with the REST client error.
     *
     * @return The HTTP status code.
     */
    public int getHttpStatus() {
        return httpStatus;
    }

    /**
     * Gets the {@link FcmError} object containing detailed information about the FCM error, if available.
     *
     * @return The {@link FcmError} object, or {@code null} if not applicable.
     */
    public FcmError getError() {
        return error;
    }

    /**
     * Overrides {@link RuntimeException#getMessage()} to provide a detailed error message including the HTTP status,
     * FCM error code, message, status, and details, if available.
     *
     * @return A string representation of the error message, enriched with additional error details.
     */
    @Override
    public String getMessage() {
        StringBuilder builder = new StringBuilder("HTTP Status ");
        builder.append(getHttpStatus()).append(": ");

        FcmError err = getError();
        if (err != null) {
            builder.append("Error Code ").append(err.getCode())
                    .append(", Message '").append(err.getMessage()).append('\'')
                    .append(", Status '").append(err.getStatus()).append('\'')
                    .append(", Details ").append(err.getDetails());
        } else {
            builder.append(super.getMessage());
        }
        return builder.toString();
    }
}
