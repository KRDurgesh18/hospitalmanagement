package com.stackly1.hospitalmanagementssystem.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String status;

    private LocalDate appointment_date;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor_id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient_id;

    // add these manually for testing
    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getAppointment_date() {
        return appointment_date;
    }

    public Doctor getDoctor_id() {
        return doctor_id;
    }

    public Patient getPatient_id() {
        return patient_id;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }



}
