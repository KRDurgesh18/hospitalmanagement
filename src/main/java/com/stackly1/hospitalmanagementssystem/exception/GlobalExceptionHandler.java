package com.stackly1.hospitalmanagementssystem.exception;

import com.stackly1.hospitalmanagementssystem.common.Commonresponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handles Doctor/Patient not found errors
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Commonresponse<Object>> 
                handleRuntimeException(RuntimeException ex) {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(Commonresponse.error(
                ex.getMessage(), 404));
    }

    // Handles wrong input errors
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Commonresponse<Object>> 
                handleIllegalArgument(
                    IllegalArgumentException ex) {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(Commonresponse.error(
                ex.getMessage(), 400));
    }

    // Handles all other errors
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Commonresponse<Object>> 
                handleGlobalException(Exception ex) {
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(Commonresponse.error(
                ex.getMessage(), 500));
    }
}