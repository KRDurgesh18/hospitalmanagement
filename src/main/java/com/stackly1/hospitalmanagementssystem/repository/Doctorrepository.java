package com.stackly1.hospitalmanagementssystem.repository;

import com.stackly1.hospitalmanagementssystem.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Doctorrepository extends JpaRepository<Doctor, Long> {

}