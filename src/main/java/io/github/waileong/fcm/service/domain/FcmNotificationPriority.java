package io.github.waileong.fcm.service.domain;


/**
 * Enum representing the priority levels for notifications.
 * For more details on Android message configuration, refer to the Firebase documentation:
 * <a href="https://firebase.google.com/docs/reference/fcm/rest/v1/projects.messages#notificationpriority">NotificationPriority</a>
 *
 * @author Wai Leong
 */
public enum FcmNotificationPriority {
    /**
     * Priority unspecified. Uses default notification priority.
     */
    PRIORITY_UNSPECIFIED,

    /**
     * Lowest notification priority. Notifications might not be shown except under special circumstances.
     */
    PRIORITY_MIN,

    /**
     * Lower notification priority. Notifications may appear smaller or in a different position.
     */
    PRIORITY_LOW,

    /**
     * Default notification priority for standard notifications.
     */
    PRIORITY_DEFAULT,

    /**
     * Higher notification priority for more important notifications or alerts.
     */
    PRIORITY_HIGH,

    /**
     * Highest notification priority for critical notifications requiring prompt user attention.
     */
    PRIORITY_MAX
}
