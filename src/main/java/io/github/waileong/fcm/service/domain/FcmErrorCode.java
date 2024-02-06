package io.github.waileong.fcm.service.domain;

/**
 * Enumerates error codes that might be returned from Firebase Cloud Messaging (FCM) in response to a message send attempt.
 * <p>
 * These error codes provide insight into why a message failed to be delivered, ranging from invalid request parameters
 * to server errors. Understanding these codes can help in implementing robust error handling and retry logic.
 * </p>
 *
 * @author Wai Leong
 * @see <a href="https://firebase.google.com/docs/reference/fcm/rest/v1/ErrorCode">FCM Error Codes Documentation</a>
 */
public enum FcmErrorCode {
    /**
     * No specific information is available about this error. Additional investigation may be required to determine the cause.
     */
    UNSPECIFIED_ERROR,

    /**
     * Request parameters were invalid. An extension of type google.rpc.BadRequest is returned to specify which field was invalid.
     */
    INVALID_ARGUMENT,

    /**
     * The app instance was unregistered from FCM. This typically means that the token used is no longer valid, and a new one must be obtained.
     */
    UNREGISTERED,

    /**
     * The authenticated sender ID is different from the sender ID for the registration token. Ensure that the request's sender ID matches the token's sender ID.
     */
    SENDER_ID_MISMATCH,

    /**
     * The sending limit was exceeded for the message target. An extension of type google.rpc.QuotaFailure is returned to specify which quota was exceeded.
     */
    QUOTA_EXCEEDED,

    /**
     * The APNs certificate or web push auth key was invalid or missing. Ensure that the correct certificate or web push authentication key is configured.
     * (HTTP error code = 401)
     */
    THIRD_PARTY_AUTH_ERROR,

    /**
     * The server is currently unavailable. This is a temporary condition, and the same request can be attempted again later.
     */
    UNAVAILABLE,

    /**
     * An unknown internal error occurred on the FCM server. This indicates an unexpected condition that prevented the message from being sent.
     */
    INTERNAL
}
