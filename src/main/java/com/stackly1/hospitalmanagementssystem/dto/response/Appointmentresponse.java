package com.stackly1.hospitalmanagementssystem.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appointmentresponse<T> {
    private LocalDateTime timestamp;
    private boolean success;
    private String message;
    private T data;

    // Helper for success responses
    public static <T> Appointmentresponse<T> success(T data, String message) {
        return Appointmentresponse.<T>builder()
                .timestamp(LocalDateTime.now())
                .success(true)
                .message(message)
                .data(data)
                .build();
    }
}