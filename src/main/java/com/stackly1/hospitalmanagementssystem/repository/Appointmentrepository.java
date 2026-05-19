package com.stackly1.hospitalmanagementssystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stackly1.hospitalmanagementssystem.entity.Appointment;

public interface Appointmentrepository extends JpaRepository<Appointment, Integer> {

    @Query("SELECT a FROM Appointment a WHERE a.patient_id.id = ?1")
    List<Appointment> findByPatientId(int patientId);

    @Query("SELECT a FROM Appointment a WHERE a.doctor_id.id = ?1")
    List<Appointment> findByDoctorId(int doctorId);
}