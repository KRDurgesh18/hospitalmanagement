package com.stackly1.hospitalmanagementssystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackly1.hospitalmanagementssystem.entity.Doctor;

@Repository
public interface Doctorrepository extends JpaRepository<Doctor, Integer> {
    boolean existsByEmail(String email);
    
    Optional<Doctor> findById(Integer id);
    
    Optional<Doctor> findByDoctorname(String doctorname);
    
    Optional<Doctor> findByPhnumber(String phnumber);
    
    Optional<Doctor> findByEmail(String email);
    
    Optional<Doctor> findBySpecialization(String specialization);
    
    Optional<Doctor> findByAvailablestatus(String availablestatus);
    
    Optional<Doctor> findByShifttype(String shifttype);
}