package io.github.waileong.fcm.service.domain;


import java.util.List;
import java.util.Map;

/**
 * @author Wai Leong
 */
public class FcmError {
    private int code;
    private String message;
    private String status;
    private List<Map<String, Object>> details;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Map<String, Object>> getDetails() {
        return details;
    }

    public void setDetails(List<Map<String, Object>> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "FcmError{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                ", details=" + details +
                '}';
    }
}
