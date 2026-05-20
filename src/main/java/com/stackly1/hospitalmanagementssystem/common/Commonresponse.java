package com.stackly1.hospitalmanagementssystem.common;

import java.time.LocalDateTime;

public class Commonresponse<T> {
    private boolean success;
    private String message;
    private T data;
    private LocalDateTime timestamp;

    public Commonresponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }

    // Quick helper methods to make controller code cleaner
    public static <T> Commonresponse<T> success(String message, T data) {
        return new Commonresponse<>(true, message, data);
    }

    public static <T> Commonresponse<T> error(String message) {
        return new Commonresponse<>(false, message, null);
    }

    // Getters and Setters
    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}