package com.stackly1.hospitalmanagementssystem.common;

public class Commonresponse<T> {
    private String statuscode;
    private String message;
    private T data;

    // Default Constructor (Fixes the "new Commonresponse<>()" error)
    public Commonresponse() {
    }

    // All-Args Constructor
    public Commonresponse(String statuscode, String message, T data) {
        this.statuscode = statuscode;
        this.message = message;
        this.data = data;
    }

    // --- GETTERS AND SETTERS ---
    
    public String getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(String statuscode) {
        this.statuscode = statuscode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}