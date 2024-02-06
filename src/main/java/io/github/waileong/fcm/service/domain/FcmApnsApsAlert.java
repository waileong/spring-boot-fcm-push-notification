package io.github.waileong.fcm.service.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the alert information for an APNs (Apple Push Notification service) message.
 * <p>
 * This class encapsulates the various elements of an APNs alert, including localized strings and
 * the launch image name. It supports both simple alerts with a body text and more complex alerts
 * with a title, subtitle, and localized content. Designed to configure notifications as per the
 * requirements detailed in Apple's documentation for remote notifications.
 * </p>
 * <p>
 * For further details on configuring APNs alerts, see the official Apple documentation:
 * <a href="https://developer.apple.com/documentation/usernotifications/setting_up_a_remote_notification_server/generating_a_remote_notification#2943365">Generating a Remote Notification</a>
 * </p>
 *
 * @author Wai Leong
 */
public class FcmApnsApsAlert {
    private String title;
    private String body;
    private String subtitle;
    @JsonProperty("title-loc-key")
    private String titleLocKey;
    @JsonProperty("title-loc-args")
    private String[] titleLocArgs;
    @JsonProperty("action-loc-key")
    private String actionLocKey;
    @JsonProperty("loc-key")
    private String locKey;
    @JsonProperty("loc-args")
    private String[] locArgs;
    @JsonProperty("launch-image")
    private String launchImage;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getTitleLocKey() {
        return titleLocKey;
    }

    public void setTitleLocKey(String titleLocKey) {
        this.titleLocKey = titleLocKey;
    }

    public String[] getTitleLocArgs() {
        return titleLocArgs;
    }

    public void setTitleLocArgs(String[] titleLocArgs) {
        this.titleLocArgs = titleLocArgs;
    }

    public String getActionLocKey() {
        return actionLocKey;
    }

    public void setActionLocKey(String actionLocKey) {
        this.actionLocKey = actionLocKey;
    }

    public String getLocKey() {
        return locKey;
    }

    public void setLocKey(String locKey) {
        this.locKey = locKey;
    }

    public String[] getLocArgs() {
        return locArgs;
    }

    public void setLocArgs(String[] locArgs) {
        this.locArgs = locArgs;
    }

    public String getLaunchImage() {
        return launchImage;
    }

    public void setLaunchImage(String launchImage) {
        this.launchImage = launchImage;
    }

    public static final class Builder {
        private String title;
        private String body;
        private String subtitle;
        private String titleLocKey;
        private String[] titleLocArgs;
        private String actionLocKey;
        private String locKey;
        private String[] locArgs;
        private String launchImage;

        private Builder() {
        }

        public static Builder aFcmApnsApsAlert() {
            return new Builder();
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Builder subtitle(String subtitle) {
            this.subtitle = subtitle;
            return this;
        }

        public Builder titleLocKey(String titleLocKey) {
            this.titleLocKey = titleLocKey;
            return this;
        }

        public Builder titleLocArgs(String[] titleLocArgs) {
            this.titleLocArgs = titleLocArgs;
            return this;
        }

        public Builder actionLocKey(String actionLocKey) {
            this.actionLocKey = actionLocKey;
            return this;
        }

        public Builder locKey(String locKey) {
            this.locKey = locKey;
            return this;
        }

        public Builder locArgs(String[] locArgs) {
            this.locArgs = locArgs;
            return this;
        }

        public Builder launchImage(String launchImage) {
            this.launchImage = launchImage;
            return this;
        }

        public FcmApnsApsAlert build() {
            FcmApnsApsAlert fcmApnsApsAlert = new FcmApnsApsAlert();
            fcmApnsApsAlert.setTitle(title);
            fcmApnsApsAlert.setBody(body);
            fcmApnsApsAlert.setSubtitle(subtitle);
            fcmApnsApsAlert.setTitleLocKey(titleLocKey);
            fcmApnsApsAlert.setTitleLocArgs(titleLocArgs);
            fcmApnsApsAlert.setActionLocKey(actionLocKey);
            fcmApnsApsAlert.setLocKey(locKey);
            fcmApnsApsAlert.setLocArgs(locArgs);
            fcmApnsApsAlert.setLaunchImage(launchImage);
            return fcmApnsApsAlert;
        }
    }
}
