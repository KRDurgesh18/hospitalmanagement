package com.stackly1.hospitalmanagementssystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackly1.hospitalmanagementssystem.entity.Appointment;

@Repository
public interface Appointmentrepository extends JpaRepository<Appointment,Integer>{
	
}






