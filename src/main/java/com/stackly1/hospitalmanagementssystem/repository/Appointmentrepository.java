package com.stackly1.hospitalmanagementssystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackly1.hospitalmanagementssystem.dto.request.AppointmentDeleterequest;
import com.stackly1.hospitalmanagementssystem.entity.Appointment;

public interface Appointmentrepository extends JpaRepository<Appointment,Integer>{

	void deleteById(AppointmentDeleterequest id);

}
