package com.synergiz.itctc.exception;

import java.time.LocalDateTime;

public class ApiErrorResponse {

    private boolean success;

    private int status;

    private String message;

    private String path;

    private LocalDateTime timestamp;

    public ApiErrorResponse() {
    }

    public ApiErrorResponse(boolean success,
                            int status,
                            String message,
                            String path,
                            LocalDateTime timestamp) {
        this.success = success;
        this.status = status;
        this.message = message;
        this.path = path;
        this.timestamp = timestamp;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}