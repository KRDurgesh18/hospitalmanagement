package com.stackly1.hospitalmanagementssystem.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctorrequest {

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50,
          message = "Name must be between 3 and 50 characters")
    private String name;

    @NotBlank(message = "Specialization is required")
    private String specialization;

    @NotBlank(message = "Email is required")
    @Email(message = "Email format is invalid")
    private String email;

    @NotBlank(message = "Phone is required")
    @Pattern(
        regexp = "^[0-9]{10}$",
        message = "Phone must be exactly 10 digits"
    )
    private String phone;

    @NotBlank(message = "Qualification is required")
    private String qualification;

    private boolean available;

    // ==========================================
    // Doctor Schedule Fields
    // ==========================================

    @NotBlank(message = "Start time is required")
    private String startTime;      // Example: 09:00 AM

    @NotBlank(message = "End time is required")
    private String endTime;        // Example: 05:00 PM

    @NotBlank(message = "Available days are required")
    private String availableDays;  // Example: Monday,Wednesday,Friday
}