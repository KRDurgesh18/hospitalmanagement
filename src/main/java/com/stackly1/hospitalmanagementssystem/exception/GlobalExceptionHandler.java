package com.stackly1.hospitalmanagementssystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.stackly1.hospitalmanagementssystem.common.Commonresponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handles the explicit RuntimeExceptions thrown from your Service layer logic
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Commonresponse<Void>> handleRuntimeException(RuntimeException ex) {
        return new ResponseEntity<>(Commonresponse.error(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    // Fallback global handler for unexpected system errors (NullPointer, SQL issues, etc)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Commonresponse<Void>> handleGenericException(Exception ex) {
        return new ResponseEntity<>(Commonresponse.error("An unexpected server error occurred: " + ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}