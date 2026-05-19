package com.stackly1.hospitalmanagementssystem.repository;

import com.stackly1.hospitalmanagementssystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Patientrepository extends JpaRepository<Patient, Long> {

    boolean existsByEmail(String email);
}