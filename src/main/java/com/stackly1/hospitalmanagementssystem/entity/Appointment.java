package com.stackly1.hospitalmanagementssystem.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
    private String status;
    private LocalDate appointment_date;
    private Doctor doctor_id;
    private Patient patient_id;
}
