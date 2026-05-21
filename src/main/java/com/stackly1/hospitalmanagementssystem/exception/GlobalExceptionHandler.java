package com.stackly1.hospitalmanagementssystem.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.stackly1.hospitalmanagementssystem.common.Commonresponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 400 → Validation failed
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Commonresponse> handleValidation(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors()
                .forEach(error -> {
                    String field =
                            ((FieldError) error).getField();
                    String message =
                            error.getDefaultMessage();
                    errors.put(field, message);
                });

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)     // 400
                .body(Commonresponse.badRequest(
                        "Validation failed: "
                        + errors.toString()));
    }

    // 404 → Doctor not found
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Commonresponse> handleNotFound(
            ResourceNotFoundException ex) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)       // 404
                .body(Commonresponse.notFound(
                        ex.getMessage()));
    }

    // 400 → Duplicate email or phone
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Commonresponse> handleRuntime(
            RuntimeException ex) {

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)     // 400
                .body(Commonresponse.badRequest(
                        ex.getMessage()));
    }

    // 500 → Unexpected server error
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Commonresponse> handleGlobal(
            Exception ex) {

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR) // 500
                .body(Commonresponse.serverError(
                        "Something went wrong: "
                        + ex.getMessage()));
    }
}