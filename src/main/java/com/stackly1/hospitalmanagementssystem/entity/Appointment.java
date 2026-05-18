package com.stackly1.hospitalmanagementssystem.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="appointment")
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="appointment_id")
    private int id;

    @Column(name="status")
    private String status;

    @Column(name="appointment_date")
    private LocalDate appointmentDate;

    @ManyToOne
    @JoinColumn(name="doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name="patient_id", nullable = false)
    private Patient patient;

	
	
}