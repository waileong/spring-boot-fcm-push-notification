package io.github.waileong.fcm.service.domain;

/**
 * Enum representing the visibility levels for notifications on lockscreens.
 * <p>
 * Determines how notifications are displayed on the lockscreen, ranging from showing all content to hiding it completely on secure lockscreens.
 * For more details on notification visibility, refer to the Firebase documentation:
 * <a href="https://firebase.google.com/docs/reference/fcm/rest/v1/projects.messages#visibility">Notification Visibility</a>.
 * </p>
 *
 * @author Wai Leong
 **/
public enum FcmVisibility {
    /**
     * If unspecified, default to Visibility.PRIVATE.
     */
    VISIBILITY_UNSPECIFIED,

    /**
     * Show this notification on all lockscreens, but conceal sensitive or private information on secure lockscreens.
     */
    PRIVATE,

    /**
     * Show this notification in its entirety on all lockscreens.
     */
    PUBLIC,

    /**
     * Do not reveal any part of this notification on a secure lockscreen.
     */
    SECRET
}
