package com.stackly1.hospitalmanagementssystem.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.stackly1.hospitalmanagementssystem.common.Commonresponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // ================= VALIDATION EXCEPTION =================

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Commonresponse handleValidationException(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors =
                new HashMap<>();

        ex.getBindingResult().getFieldErrors()
                .forEach(error -> {

                    errors.put(
                            error.getField(),
                            error.getDefaultMessage()
                    );
                });

        Commonresponse response =
                new Commonresponse();

        response.setStatuscode("400");
        response.setMessage("Validation Failed");
        response.setData(errors);

        return response;
    }

    // ================= RUNTIME EXCEPTION =================

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RuntimeException.class)
    public Commonresponse handleRuntimeException(
            RuntimeException ex) {

        Commonresponse response =
                new Commonresponse();

        response.setStatuscode("404");
        response.setMessage(ex.getMessage());
        response.setData(null);

        return response;
    }

    // ================= DATABASE EXCEPTION =================

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public Commonresponse handleDatabaseException(
            DataIntegrityViolationException ex) {

        Commonresponse response =
                new Commonresponse();

        response.setStatuscode("400");
        response.setMessage("Database Error");
        response.setData(
                ex.getMostSpecificCause().getMessage());

        return response;
    }

    // ================= INVALID JSON EXCEPTION =================

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Commonresponse handleInvalidJsonException(
            HttpMessageNotReadableException ex) {

        Commonresponse response =
                new Commonresponse();

        response.setStatuscode("400");
        response.setMessage("Invalid JSON Request");
        response.setData(ex.getMessage());

        return response;
    }

    // ================= GENERIC EXCEPTION =================

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Commonresponse handleException(
            Exception ex) {

        Commonresponse response =
                new Commonresponse();

        response.setStatuscode("500");
        response.setMessage("Internal Server Error");
        response.setData(ex.getMessage());

        return response;
    }
}