package com.stackly1.hospitalmanagementssystem.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Commonresponse {

    String statuscode;
    String message;
    Object data;

    // 200 → Fetch / Update / Delete success
    public static Commonresponse success(
            String message, Object data) {
        return new Commonresponse("200", message, data);
    }

    // 201 → New doctor created
    public static Commonresponse created(
            String message, Object data) {
        return new Commonresponse("201", message, data);
    }

    // 400 → Duplicate email/phone or bad input
    public static Commonresponse badRequest(String message) {
        return new Commonresponse("400", message, null);
    }

    // 404 → Doctor not found
    public static Commonresponse notFound(String message) {
        return new Commonresponse("404", message, null);
    }

    // 500 → Server crashed unexpectedly
    public static Commonresponse serverError(String message) {
        return new Commonresponse("500", message, null);
    }
}