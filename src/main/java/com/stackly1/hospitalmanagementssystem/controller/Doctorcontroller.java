package com.stackly1.hospitalmanagementssystem.controller;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackly1.hospitalmanagementssystem.dto.response.Doctorresponse;
import com.stackly1.hospitalmanagementssystem.dto1.request.Doctorrequest;
import com.stackly1.hospitalmanagementssystem.service.serviceImp.DoctorserviceImp;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/doctor")
public class Doctorcontroller {

	private final DoctorserviceImp doctorService;

	public Doctorcontroller(DoctorserviceImp doctorService) {
		this.doctorService = doctorService;
	}

	@PostMapping("/add")
	public ResponseEntity<Doctorresponse> createUser(@Valid @RequestBody Doctorrequest dto) {
		Doctorresponse created = doctorService.createUser(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}

	@GetMapping("/show")
	public ResponseEntity<List<Doctorresponse>> getAllUsers() {
		return ResponseEntity.ok(doctorService.getAllUsers());
	}

	@GetMapping("/show/{id}")
	public ResponseEntity<Doctorresponse> getUserById(@PathVariable Integer id) {
		return ResponseEntity.ok(doctorService.getUserById(id));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Doctorresponse> updateUser(@PathVariable Integer id, @Valid @RequestBody Doctorrequest dto) {
		return ResponseEntity.ok(doctorService.updateUser(id, dto));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, String>> deleteUser(@PathVariable Integer id) {
		doctorService.deleteUser(id);
		Map<String, String> response = new HashMap<>();
		response.put("message", "Doctor with id " + id + " is deleted successfully");
		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/delete/{doctorId}/appointment/{appointmentId}")
	public ResponseEntity<Map<String, String>> deleteAppointment(@PathVariable Integer doctorId, @PathVariable Integer appointmentId) {
		doctorService.deleteAppointment(doctorId, appointmentId);
		Map<String, String> response = new HashMap<>();
		response.put("message", "Doctor with id " + doctorId + " and Appoinment id " 
				+ appointmentId + " is deleted successfully");
		return ResponseEntity.ok(response);
	}

}
