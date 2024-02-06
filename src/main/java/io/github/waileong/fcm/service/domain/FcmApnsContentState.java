package io.github.waileong.fcm.service.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Represents the content state for updating or ending a Live Activity through APNs.
 * <p>
 * This class encapsulates the data necessary to update the state of a Live Activity on the user's device.
 * The structure and keys of the content state should align with the data model of the Live Activity being updated.
 * </p>
 *
 * @author Wai Leong
 * @see <a href="https://developer.apple.com/documentation/usernotifications/setting_up_a_remote_notification_server/generating_a_remote_notification">Generating a Remote Notification</a>
 */
public class FcmApnsContentState {
    @JsonProperty("content-state")
    private Map<String, Object> contentState;

    @JsonProperty("event")
    private String event;

    @JsonProperty("timestamp")
    private Long timestamp;


    /**
     * Gets the content state for the Live Activity.
     *
     * @return A map representing the state of the Live Activity.
     */
    public Map<String, Object> getContentState() {
        return contentState;
    }

    /**
     * Sets the content state for the Live Activity.
     *
     * @param contentState A map representing the state of the Live Activity.
     */
    public void setContentState(Map<String, Object> contentState) {
        this.contentState = contentState;
    }

    /**
     * Gets the event type for the Live Activity update.
     *
     * @return A string representing the event type.
     */
    public String getEvent() {
        return event;
    }

    /**
     * Sets the event type for the Live Activity update.
     *
     * @param event A string representing the event type.
     */
    public void setEvent(String event) {
        this.event = event;
    }

    /**
     * Gets the timestamp for when the Live Activity update occurs.
     *
     * @return The timestamp of the update.
     */
    public Long getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the timestamp for when the Live Activity update occurs.
     *
     * @param timestamp The timestamp of the update.
     */
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public static final class Builder {
        private Map<String, Object> contentState;
        private String event;
        private Long timestamp;

        private Builder() {
        }

        public static Builder aFcmApnsContentState() {
            return new Builder();
        }

        public Builder contentState(Map<String, Object> contentState) {
            this.contentState = contentState;
            return this;
        }

        public Builder event(String event) {
            this.event = event;
            return this;
        }

        public Builder timestamp(Long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public FcmApnsContentState build() {
            FcmApnsContentState fcmApnsContentState = new FcmApnsContentState();
            fcmApnsContentState.setContentState(contentState);
            fcmApnsContentState.setEvent(event);
            fcmApnsContentState.setTimestamp(timestamp);
            return fcmApnsContentState;
        }
    }
}
