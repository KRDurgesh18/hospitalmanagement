package com.stackly1.hospitalmanagementssystem.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.stackly1.hospitalmanagementssystem.common.Commonresponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Commonresponse handleValidationException(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        Commonresponse response = new Commonresponse();

        response.setStatuscode("400");
        response.setMessage("Validation Failed");
        response.setData(errors);

        return response;
    }

    @ExceptionHandler(Exception.class)
    public Commonresponse handleException(Exception ex) {

        Commonresponse response = new Commonresponse();

        response.setStatuscode("500");
        response.setMessage(ex.getMessage());
        response.setData(null);

        return response;
    }
    
    @ExceptionHandler(PatientNotFoundException.class)
    public Commonresponse handlePatientNotFoundException(
            PatientNotFoundException ex) {

        Commonresponse response = new Commonresponse();

        response.setStatuscode("404");
        response.setMessage(ex.getMessage());
        response.setData(null);

        return response;
    }
}