package com.stackly1.hospitalmanagementssystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackly1.hospitalmanagementssystem.entity.Doctor;

@Repository
public interface Doctorrepository extends JpaRepository<Doctor, Integer> {

	Optional<Doctor> findByEmail(String email);
    boolean existsByEmail(String email);
}