package com.stackly1.hospitalmanagementssystem.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;

    private String name;
    private String specialization;
    private String phNumber;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getPhNumber() {
        return phNumber;
    }

    public void setPhNumber(String phNumber) {
        this.phNumber = phNumber;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(
           List<Appointment> appointments) {

        this.appointments = appointments;
    }
}