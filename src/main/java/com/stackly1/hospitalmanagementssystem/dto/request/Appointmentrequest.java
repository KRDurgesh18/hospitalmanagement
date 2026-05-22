package com.stackly1.hospitalmanagementssystem.dto.request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Appointmentrequest {
         private Integer doctor_id;
         private Integer patient_id;
         private LocalDate appoinment_date;
}
