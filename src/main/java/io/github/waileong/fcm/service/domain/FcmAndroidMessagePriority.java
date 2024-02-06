package io.github.waileong.fcm.service.domain;

/**
 * Enumerates the priority levels for Android messages in Firebase Cloud Messaging (FCM).
 * <p>
 * Android message priority is used to determine the delivery priority of the message on Android platforms.
 * There are two levels of priority:
 * <ul>
 * <li>{@code NORMAL} - The message might be delayed to conserve battery.</li>
 * <li>{@code HIGH} - The message is sent immediately and might wake a sleeping device.</li>
 * </ul>
 * </p>
 * <p>
 * For more information on Android message priority, see the official Firebase documentation:
 * <a href="https://firebase.google.com/docs/reference/fcm/rest/v1/projects.messages#androidmessagepriority">AndroidMessagePriority</a>
 * </p>
 *
 * @author Wai Leong
 */
public enum FcmAndroidMessagePriority {
    /**
     * Normal priority. Messages with this priority might be delayed to conserve the battery of the device.
     */
    NORMAL,

    /**
     * High priority. Messages with this priority are sent immediately and may wake a sleeping device.
     */
    HIGH;
}
