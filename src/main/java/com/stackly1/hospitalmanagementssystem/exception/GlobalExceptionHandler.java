package com.stackly1.hospitalmanagementssystem.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.stackly1.hospitalmanagementssystem.common.Commonresponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Commonresponse>
    handleResourceNotFoundException(ResourceNotFoundException ex) {

        Commonresponse response = new Commonresponse();

        response.setStatusCode(404);
        response.setMessage(ex.getMessage());
        response.setData("null");

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}