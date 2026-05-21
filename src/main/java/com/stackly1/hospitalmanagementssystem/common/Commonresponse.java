package com.stackly1.hospitalmanagementssystem.common;

public class Commonresponse<T> {

    // true = success, false = error
    private boolean success;

    // Message to show user
    private String message;

    // Actual data (Doctor, Patient, Appointment)
    private T data;

    // HTTP status code
    private int statusCode;

    // ===== CONSTRUCTOR for SUCCESS =====
    public Commonresponse(boolean success, 
                          String message, 
                          T data, 
                          int statusCode) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.statusCode = statusCode;
    }

    // ===== STATIC METHODS =====

    // Call this when operation is successful
    public static <T> Commonresponse<T> success(
                       String message, T data) {
        return new Commonresponse<>(true, message, data, 200);
    }

    // Call this when operation fails
    public static <T> Commonresponse<T> error(
                       String message, int statusCode) {
        return new Commonresponse<>(
                   false, message, null, statusCode);
    }

    // ===== GETTERS =====
    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
    public T getData() { return data; }
    public int getStatusCode() { return statusCode; }

    // ===== SETTERS =====
    public void setSuccess(boolean success) { 
        this.success = success; }
    public void setMessage(String message) { 
        this.message = message; }
    public void setData(T data) { this.data = data; }
    public void setStatusCode(int statusCode) { 
        this.statusCode = statusCode; }
}