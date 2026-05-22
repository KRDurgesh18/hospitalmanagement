package com.stackly1.hospitalmanagementssystem.common;

public class Commonresponse {

    private int statuscode;

    private String message;

    private Object data;

    public int getStatusCode() {
        return statuscode;
    }

    public void setStatusCode(int statusCode) {
        this.statuscode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}