package com.stackly1.hospitalmanagementssystem.dto.response;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Appointmentresponse {
      private Integer id;
      private String status;
      private LocalDate appointment_date;
      private Integer doctor_id;
      private Integer patient_id;
      
}
