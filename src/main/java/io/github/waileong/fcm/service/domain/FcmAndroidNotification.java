package io.github.waileong.fcm.service.domain;

/**
 * Represents an Android-specific configuration for notifications sent through Firebase Cloud Messaging (FCM).
 * <p>
 * This class includes settings for the notification's appearance and behavior on Android devices, such as the title, body,
 * icon, color, sound, and more. It allows for configuring advanced options like localization keys for the title and body,
 * notification priority, visibility, light settings, and vibration patterns.
 * </p>
 * <p>
 * For detailed information on each option, see the official Firebase documentation:
 * <a href="https://firebase.google.com/docs/reference/fcm/rest/v1/projects.messages#androidnotification">AndroidNotification</a>
 * </p>
 *
 * @author Wai Leong
 */
public class FcmAndroidNotification {
    private String title;
    private String body;
    private String icon;
    private String color;
    private String sound;
    private String tag;
    private String clickAction;
    private String bodyLocKey;
    private String[] bodyLocArgs;
    private String titleLocKey;
    private String[] titleLocArgs;
    private String channelId;
    private String ticker;
    private Boolean sticky;
    private String eventTime;
    private Boolean localOnly;
    private FcmNotificationPriority notificationPriority;
    private Boolean defaultSound;
    private Boolean defaultVibrateTimings;
    private Boolean defaultLightSettings;
    private String[] vibrateTimings;
    private FcmVisibility visibility;
    private Integer notificationCount;
    private FcmLightSettings lightSettings;
    private String image;

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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getClickAction() {
        return clickAction;
    }

    public void setClickAction(String clickAction) {
        this.clickAction = clickAction;
    }

    public String getBodyLocKey() {
        return bodyLocKey;
    }

    public void setBodyLocKey(String bodyLocKey) {
        this.bodyLocKey = bodyLocKey;
    }

    public String[] getBodyLocArgs() {
        return bodyLocArgs;
    }

    public void setBodyLocArgs(String[] bodyLocArgs) {
        this.bodyLocArgs = bodyLocArgs;
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

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public Boolean getSticky() {
        return sticky;
    }

    public void setSticky(Boolean sticky) {
        this.sticky = sticky;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public Boolean getLocalOnly() {
        return localOnly;
    }

    public void setLocalOnly(Boolean localOnly) {
        this.localOnly = localOnly;
    }

    public FcmNotificationPriority getNotificationPriority() {
        return notificationPriority;
    }

    public void setNotificationPriority(FcmNotificationPriority notificationPriority) {
        this.notificationPriority = notificationPriority;
    }

    public Boolean getDefaultSound() {
        return defaultSound;
    }

    public void setDefaultSound(Boolean defaultSound) {
        this.defaultSound = defaultSound;
    }

    public Boolean getDefaultVibrateTimings() {
        return defaultVibrateTimings;
    }

    public void setDefaultVibrateTimings(Boolean defaultVibrateTimings) {
        this.defaultVibrateTimings = defaultVibrateTimings;
    }

    public Boolean getDefaultLightSettings() {
        return defaultLightSettings;
    }

    public void setDefaultLightSettings(Boolean defaultLightSettings) {
        this.defaultLightSettings = defaultLightSettings;
    }

    public String[] getVibrateTimings() {
        return vibrateTimings;
    }

    public void setVibrateTimings(String[] vibrateTimings) {
        this.vibrateTimings = vibrateTimings;
    }

    public FcmVisibility getVisibility() {
        return visibility;
    }

    public void setVisibility(FcmVisibility visibility) {
        this.visibility = visibility;
    }

    public Integer getNotificationCount() {
        return notificationCount;
    }

    public void setNotificationCount(Integer notificationCount) {
        this.notificationCount = notificationCount;
    }

    public FcmLightSettings getLightSettings() {
        return lightSettings;
    }

    public void setLightSettings(FcmLightSettings lightSettings) {
        this.lightSettings = lightSettings;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Builder class for {@link FcmAndroidNotification}.
     * Provides a fluent interface for constructing instances with custom configurations.
     */
    public static final class Builder {
        private String title;
        private String body;
        private String icon;
        private String color;
        private String sound;
        private String tag;
        private String clickAction;
        private String bodyLocKey;
        private String[] bodyLocArgs;
        private String titleLocKey;
        private String[] titleLocArgs;
        private String channelId;
        private String ticker;
        private Boolean sticky;
        private String eventTime;
        private Boolean localOnly;
        private FcmNotificationPriority notificationPriority;
        private Boolean defaultSound;
        private Boolean defaultVibrateTimings;
        private Boolean defaultLightSettings;
        private String[] vibrateTimings;
        private FcmVisibility visibility;
        private Integer notificationCount;
        private FcmLightSettings lightSettings;
        private String image;

        private Builder() {
        }

        /**
         * Creates a new Builder instance for constructing an {@link FcmAndroidNotification}.
         *
         * @return A new Builder instance.
         */
        public static Builder aFcmAndroidNotification() {
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

        public Builder icon(String icon) {
            this.icon = icon;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Builder sound(String sound) {
            this.sound = sound;
            return this;
        }

        public Builder tag(String tag) {
            this.tag = tag;
            return this;
        }

        public Builder clickAction(String clickAction) {
            this.clickAction = clickAction;
            return this;
        }

        public Builder bodyLocKey(String bodyLocKey) {
            this.bodyLocKey = bodyLocKey;
            return this;
        }

        public Builder bodyLocArgs(String[] bodyLocArgs) {
            this.bodyLocArgs = bodyLocArgs;
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

        public Builder channelId(String channelId) {
            this.channelId = channelId;
            return this;
        }

        public Builder ticker(String ticker) {
            this.ticker = ticker;
            return this;
        }

        public Builder sticky(Boolean sticky) {
            this.sticky = sticky;
            return this;
        }

        public Builder eventTime(String eventTime) {
            this.eventTime = eventTime;
            return this;
        }

        public Builder localOnly(Boolean localOnly) {
            this.localOnly = localOnly;
            return this;
        }

        public Builder notificationPriority(FcmNotificationPriority notificationPriority) {
            this.notificationPriority = notificationPriority;
            return this;
        }

        public Builder defaultSound(Boolean defaultSound) {
            this.defaultSound = defaultSound;
            return this;
        }

        public Builder defaultVibrateTimings(Boolean defaultVibrateTimings) {
            this.defaultVibrateTimings = defaultVibrateTimings;
            return this;
        }

        public Builder defaultLightSettings(Boolean defaultLightSettings) {
            this.defaultLightSettings = defaultLightSettings;
            return this;
        }

        public Builder vibrateTimings(String[] vibrateTimings) {
            this.vibrateTimings = vibrateTimings;
            return this;
        }

        public Builder visibility(FcmVisibility visibility) {
            this.visibility = visibility;
            return this;
        }

        public Builder notificationCount(Integer notificationCount) {
            this.notificationCount = notificationCount;
            return this;
        }

        public Builder lightSettings(FcmLightSettings lightSettings) {
            this.lightSettings = lightSettings;
            return this;
        }

        public Builder image(String image) {
            this.image = image;
            return this;
        }

        /**
         * Builds and returns an {@link FcmAndroidNotification} with the configured properties.
         *
         * @return An instance of FcmAndroidNotification.
         */
        public FcmAndroidNotification build() {
            FcmAndroidNotification fcmAndroidNotification = new FcmAndroidNotification();
            fcmAndroidNotification.setTitle(title);
            fcmAndroidNotification.setBody(body);
            fcmAndroidNotification.setIcon(icon);
            fcmAndroidNotification.setColor(color);
            fcmAndroidNotification.setSound(sound);
            fcmAndroidNotification.setTag(tag);
            fcmAndroidNotification.setClickAction(clickAction);
            fcmAndroidNotification.setBodyLocKey(bodyLocKey);
            fcmAndroidNotification.setBodyLocArgs(bodyLocArgs);
            fcmAndroidNotification.setTitleLocKey(titleLocKey);
            fcmAndroidNotification.setTitleLocArgs(titleLocArgs);
            fcmAndroidNotification.setChannelId(channelId);
            fcmAndroidNotification.setTicker(ticker);
            fcmAndroidNotification.setSticky(sticky);
            fcmAndroidNotification.setEventTime(eventTime);
            fcmAndroidNotification.setLocalOnly(localOnly);
            fcmAndroidNotification.setNotificationPriority(notificationPriority);
            fcmAndroidNotification.setDefaultSound(defaultSound);
            fcmAndroidNotification.setDefaultVibrateTimings(defaultVibrateTimings);
            fcmAndroidNotification.setDefaultLightSettings(defaultLightSettings);
            fcmAndroidNotification.setVibrateTimings(vibrateTimings);
            fcmAndroidNotification.setVisibility(visibility);
            fcmAndroidNotification.setNotificationCount(notificationCount);
            fcmAndroidNotification.setLightSettings(lightSettings);
            fcmAndroidNotification.setImage(image);
            return fcmAndroidNotification;
        }
    }
}
