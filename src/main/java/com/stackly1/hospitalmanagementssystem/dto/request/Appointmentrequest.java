package com.stackly1.hospitalmanagementssystem.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Data;

@Data
public class Appointmentrequest {

    @NotNull(message = "Doctor ID is required")
    private Integer doctor_id;

    @NotNull(message = "Patient ID is required")
    private Integer patient_id;

    @NotNull(message = "Appointment date is required")
    @FutureOrPresent(message = "Appointment date cannot be in the past")
    private LocalDate appointment_date;
}