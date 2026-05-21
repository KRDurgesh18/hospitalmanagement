package com.stackly1.hospitalmanagementssystem.common;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommonResponse<T> {
    private LocalDateTime timestamp;
    private boolean success;
    private String message;
    private T data;

    // Helper for success responses
    public static <T> CommonResponse<T> success(T data, String message) {
        return CommonResponse.<T>builder()
                .timestamp(LocalDateTime.now())
                .success(true)
                .message(message)
                .data(data)
                .build();
    }

    // Helper for error responses
    public static <T> CommonResponse<T> error(String message) {
        return CommonResponse.<T>builder()
                .timestamp(LocalDateTime.now())
                .success(false)
                .message(message)
                .data(null)
                .build();
    }
}
