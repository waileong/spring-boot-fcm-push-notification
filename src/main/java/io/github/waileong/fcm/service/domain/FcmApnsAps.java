package io.github.waileong.fcm.service.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Represents the APS dictionary for an APNs payload, encapsulating alert information and various notification settings.
 * <p>
 * This class is structured to accommodate settings for the appearance and behavior of notifications sent through APNs,
 * including options for sound, badge count, content availability, and advanced features like interruption levels and relevance scores.
 * </p>
 *
 * @author Wai Leong
 * @see <a href="https://firebase.google.com/docs/reference/fcm/rest/v1/projects.messages#apnsconfig">APNs Config in FCM</a>
 * @see <a href="https://developer.apple.com/documentation/usernotifications/setting_up_a_remote_notification_server/generating_a_remote_notification">Generating a Remote Notification</a>
 */
public class FcmApnsAps {
    private FcmApnsApsAlert alert;
    private Integer badge;
    private FcmApnsCriticalSound sound;
    @JsonProperty("content-available")
    private Integer contentAvailable;
    private String category;
    @JsonProperty("thread-id")
    private String threadId;
    @JsonProperty("mutable-content")
    private Integer mutableContent;
    @JsonProperty("target-content-id")
    private String targetContentId;
    @JsonProperty("interruption-level")
    private String interruptionLevel;
    @JsonProperty("relevance-score")
    private Double relevanceScore;
    @JsonProperty("filter-criteria")
    private String filterCriteria;
    @JsonProperty("stale-date")
    private Long staleDate;
    @JsonProperty("content-state")
    private FcmApnsContentState contentState;
    @JsonProperty("dismissal-date")
    private Long dismissalDate;
    @JsonProperty("attributes-type")
    private String attributesType;
    private Map<String, Object> attributes; // Detailed attributes for Live Activities or other uses

    public FcmApnsApsAlert getAlert() {
        return alert;
    }

    public void setAlert(FcmApnsApsAlert alert) {
        this.alert = alert;
    }

    public Integer getBadge() {
        return badge;
    }

    public void setBadge(Integer badge) {
        this.badge = badge;
    }

    public FcmApnsCriticalSound getSound() {
        return sound;
    }

    public void setSound(FcmApnsCriticalSound sound) {
        this.sound = sound;
    }

    public Integer getContentAvailable() {
        return contentAvailable;
    }

    public void setContentAvailable(Integer contentAvailable) {
        this.contentAvailable = contentAvailable;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getThreadId() {
        return threadId;
    }

    public void setThreadId(String threadId) {
        this.threadId = threadId;
    }

    public Integer getMutableContent() {
        return mutableContent;
    }

    public void setMutableContent(Integer mutableContent) {
        this.mutableContent = mutableContent;
    }

    public String getTargetContentId() {
        return targetContentId;
    }

    public void setTargetContentId(String targetContentId) {
        this.targetContentId = targetContentId;
    }

    public String getInterruptionLevel() {
        return interruptionLevel;
    }

    public void setInterruptionLevel(String interruptionLevel) {
        this.interruptionLevel = interruptionLevel;
    }

    public Double getRelevanceScore() {
        return relevanceScore;
    }

    public void setRelevanceScore(Double relevanceScore) {
        this.relevanceScore = relevanceScore;
    }

    public String getFilterCriteria() {
        return filterCriteria;
    }

    public void setFilterCriteria(String filterCriteria) {
        this.filterCriteria = filterCriteria;
    }

    public Long getStaleDate() {
        return staleDate;
    }

    public void setStaleDate(Long staleDate) {
        this.staleDate = staleDate;
    }

    public FcmApnsContentState getContentState() {
        return contentState;
    }

    public void setContentState(FcmApnsContentState contentState) {
        this.contentState = contentState;
    }

    public Long getDismissalDate() {
        return dismissalDate;
    }

    public void setDismissalDate(Long dismissalDate) {
        this.dismissalDate = dismissalDate;
    }

    public String getAttributesType() {
        return attributesType;
    }

    public void setAttributesType(String attributesType) {
        this.attributesType = attributesType;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public static final class Builder {
        private FcmApnsApsAlert alert;
        private Integer badge;
        private FcmApnsCriticalSound sound;
        private Integer contentAvailable;
        private String category;
        private String threadId;
        private Integer mutableContent;
        private String targetContentId;
        private String interruptionLevel;
        private Double relevanceScore;
        private String filterCriteria;
        private Long staleDate;
        private FcmApnsContentState contentState;
        private Long dismissalDate;
        private String attributesType;
        private Map<String, Object> attributes;

        private Builder() {
        }

        public static Builder aFcmApnsAps() {
            return new Builder();
        }

        public Builder alert(FcmApnsApsAlert alert) {
            this.alert = alert;
            return this;
        }

        public Builder badge(Integer badge) {
            this.badge = badge;
            return this;
        }

        public Builder sound(FcmApnsCriticalSound sound) {
            this.sound = sound;
            return this;
        }

        public Builder contentAvailable(Integer contentAvailable) {
            this.contentAvailable = contentAvailable;
            return this;
        }

        public Builder category(String category) {
            this.category = category;
            return this;
        }

        public Builder threadId(String threadId) {
            this.threadId = threadId;
            return this;
        }

        public Builder mutableContent(Integer mutableContent) {
            this.mutableContent = mutableContent;
            return this;
        }

        public Builder targetContentId(String targetContentId) {
            this.targetContentId = targetContentId;
            return this;
        }

        public Builder interruptionLevel(String interruptionLevel) {
            this.interruptionLevel = interruptionLevel;
            return this;
        }

        public Builder relevanceScore(Double relevanceScore) {
            this.relevanceScore = relevanceScore;
            return this;
        }

        public Builder filterCriteria(String filterCriteria) {
            this.filterCriteria = filterCriteria;
            return this;
        }

        public Builder staleDate(Long staleDate) {
            this.staleDate = staleDate;
            return this;
        }

        public Builder contentState(FcmApnsContentState contentState) {
            this.contentState = contentState;
            return this;
        }

        public Builder dismissalDate(Long dismissalDate) {
            this.dismissalDate = dismissalDate;
            return this;
        }

        public Builder attributesType(String attributesType) {
            this.attributesType = attributesType;
            return this;
        }

        public Builder attributes(Map<String, Object> attributes) {
            this.attributes = attributes;
            return this;
        }

        public FcmApnsAps build() {
            FcmApnsAps fcmApnsAps = new FcmApnsAps();
            fcmApnsAps.setAlert(alert);
            fcmApnsAps.setBadge(badge);
            fcmApnsAps.setSound(sound);
            fcmApnsAps.setContentAvailable(contentAvailable);
            fcmApnsAps.setCategory(category);
            fcmApnsAps.setThreadId(threadId);
            fcmApnsAps.setMutableContent(mutableContent);
            fcmApnsAps.setTargetContentId(targetContentId);
            fcmApnsAps.setInterruptionLevel(interruptionLevel);
            fcmApnsAps.setRelevanceScore(relevanceScore);
            fcmApnsAps.setFilterCriteria(filterCriteria);
            fcmApnsAps.setStaleDate(staleDate);
            fcmApnsAps.setContentState(contentState);
            fcmApnsAps.setDismissalDate(dismissalDate);
            fcmApnsAps.setAttributesType(attributesType);
            fcmApnsAps.setAttributes(attributes);
            return fcmApnsAps;
        }
    }
}
