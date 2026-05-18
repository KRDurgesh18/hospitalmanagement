package com.stackly1.hospitalmanagementssystem.dto.request;

import java.time.LocalDate;
import lombok.Data;

@Data
public class Appointmentrequest {

    private String status;
    private Integer doctorId;
    private Integer patientId;
    private LocalDate appointmentDate;
}
