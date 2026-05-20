package com.stackly1.hospitalmanagementssystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackly1.hospitalmanagementssystem.entity.Patient;

public interface Patientrepository extends JpaRepository<Patient, Long> {

}
