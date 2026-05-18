package com.stackly1.hospitalmanagementssystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackly1.hospitalmanagementssystem.dto.request.AppointmentDeleterequest;
import com.stackly1.hospitalmanagementssystem.dto.request.AppointmentDoctorId;
import com.stackly1.hospitalmanagementssystem.dto.request.AppointmentPatientId;
import com.stackly1.hospitalmanagementssystem.dto.request.Appointmentrequest;
import com.stackly1.hospitalmanagementssystem.entity.Appointment;
import com.stackly1.hospitalmanagementssystem.service.Appointmentservice;

@RestController
@RequestMapping("/appointment")
@CrossOrigin
public class Appointmentcontroller {

	@Autowired
	private Appointmentservice appointmentservice;

	@PostMapping("/saveAppointment")
	public Object saveAppointment(@RequestBody Appointmentrequest appointmentrequest) {
		return (appointmentservice.saveAppointment(appointmentrequest));
	}

//	@DeleteMapping("/deleteById")
//	public Object deleteAppointmentById(@RequestBody AppointmentDeleterequest id) {
//
//		return(appointmentservice.deleteAppointmentById(id));
//
//	    
//	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteAppointment(@RequestBody AppointmentDeleterequest request) {

		return ResponseEntity.ok(appointmentservice.deleteAppointmentById(request.getId()));
	}

	@GetMapping("/getAllAppointment")
	public Object getAllAppointment() {
		return (appointmentservice.getAllAppointment());
	}

	@GetMapping("patientId")
	public ResponseEntity<?> getAppointmentsByPatient(@RequestBody AppointmentPatientId patientId) {

		return ResponseEntity.ok(appointmentservice.getAppointmentsByPatientId(patientId.getAppointmentPatientId()));
	}
	
	@GetMapping("doctorId")
	public ResponseEntity<?> getAppointmentsByDoctor(@RequestBody AppointmentDoctorId doctorId) {

		return ResponseEntity.ok(appointmentservice.getAppointmentsByDoctor(doctorId.getDoctorId()));
	}
}
