package com.stackly1.hospitalmanagementssystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.stackly1.hospitalmanagementssystem.dto.response.Appointmentresponse;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Appointmentresponse<String>> handleNotFound(ResourceNotFoundException ex) {
        Appointmentresponse<String> response = Appointmentresponse.<String>builder()
                .timestamp(LocalDateTime.now())
                .success(false)
                .message(ex.getMessage())
                .data(null)
                .build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Appointmentresponse<String>> handleGlobal(Exception ex) {
        Appointmentresponse<String> response = Appointmentresponse.<String>builder()
                .timestamp(LocalDateTime.now())
                .success(false)
                .message("Internal Server Error: " + ex.getMessage())
                .data(null)
                .build();
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}