package io.github.waileong.fcm.service.domain;

/**
 * @author Wai Leong
 */
public class FcmErrorResponse {
    private FcmError error;

    public FcmError getError() {
        return error;
    }

    public void setError(FcmError error) {
        this.error = error;
    }
}
