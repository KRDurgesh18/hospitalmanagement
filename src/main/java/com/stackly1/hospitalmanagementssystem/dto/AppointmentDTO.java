package com.stackly1.hospitalmanagementssystem.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class AppointmentDTO {
    private int id;
    private String status;
    private LocalDate appointmentDate;
    private int doctorId;
    private String doctorName;
    private int patientId;
    private String patientName;
    
    
    
}