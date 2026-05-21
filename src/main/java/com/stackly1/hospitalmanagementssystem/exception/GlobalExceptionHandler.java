package com.stackly1.hospitalmanagementssystem.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 1. Resource not found
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleResourceNotFound(
            ResourceNotFoundException ex) {

        Map<String, String> error = new HashMap<>();
        error.put("statuscode", "404");
        error.put("message", ex.getMessage());

        return error;
    }

    // 2. Validation errors (@Valid)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationException(
            MethodArgumentNotValidException ex) {

        Map<String, String> error = new HashMap<>();

        String message = ex.getBindingResult()
                           .getFieldError()
                           .getDefaultMessage();

        error.put("statuscode", "400");
        error.put("message", message);

        return error;
    }

    // 3. General exception
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> handleGeneralException(
            Exception ex) {

        Map<String, String> error = new HashMap<>();
        error.put("statuscode", "500");
        error.put("message",
                "Something went wrong. Please try again later.");

        return error;
    }
}