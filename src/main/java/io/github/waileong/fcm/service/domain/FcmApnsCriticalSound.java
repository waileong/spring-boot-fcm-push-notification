package io.github.waileong.fcm.service.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents sound information for critical alerts. Use this instead of a simple sound filename string
 * for alerts that require immediate attention.
 */
public class FcmApnsCriticalSound {
    private String name;
    private Integer volume;
    @JsonProperty("critical")
    private Integer critical; // Use 1 for critical alerts

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getCritical() {
        return critical;
    }

    public void setCritical(Integer critical) {
        this.critical = critical;
    }

    public static final class Builder {
        private String name;
        private Integer volume;
        private Integer critical;

        private Builder() {
        }

        public static Builder aFcmApnsCriticalSound() {
            return new Builder();
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder volume(Integer volume) {
            this.volume = volume;
            return this;
        }

        public Builder critical(Integer critical) {
            this.critical = critical;
            return this;
        }

        public FcmApnsCriticalSound build() {
            FcmApnsCriticalSound fcmApnsCriticalSound = new FcmApnsCriticalSound();
            fcmApnsCriticalSound.setName(name);
            fcmApnsCriticalSound.setVolume(volume);
            fcmApnsCriticalSound.setCritical(critical);
            return fcmApnsCriticalSound;
        }
    }
}