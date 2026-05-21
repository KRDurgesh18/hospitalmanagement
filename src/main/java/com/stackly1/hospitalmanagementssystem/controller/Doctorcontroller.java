package com.stackly1.hospitalmanagementssystem.controller;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackly1.hospitalmanagementssystem.common.Commonresponse;
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
	public ResponseEntity<Commonresponse<Doctorresponse>> 
	createUser(@Valid @RequestBody Doctorrequest dto) {
		Doctorresponse created = doctorService.createUser(dto);
		
		  Commonresponse<Doctorresponse> response =
		            new Commonresponse<>(
		                    HttpStatus.CREATED.value(),
		                    "Doctor created successfully",
		                    created
		            );
		  
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping("/show")
	public ResponseEntity<List<Doctorresponse>> getAllDoctors() {
		return ResponseEntity.ok(doctorService.getAllDoctors());
	}

	@GetMapping("/show/{id}")
	public ResponseEntity<Doctorresponse> getDoctorById(@PathVariable Integer id) {
		return ResponseEntity.ok(doctorService.getDoctorById(id));
	}
	
	
	@GetMapping("/show/name/{doctorname}")
	public ResponseEntity<Doctorresponse> getDoctorByName(@PathVariable String doctorname) {
		return ResponseEntity.ok(doctorService.getDoctorByName(doctorname));
	}

	@GetMapping("/show/mail/{email}")
	public ResponseEntity<Doctorresponse> getDoctorByMail(@PathVariable String email) {
		return ResponseEntity.ok(doctorService.getDoctorByMail(email));
	}
	
	@GetMapping("/show/phone/{ph_number}")
	public ResponseEntity<Doctorresponse> getDoctorByPhonenumber(@PathVariable String ph_number) {
		return ResponseEntity.ok(doctorService.getDoctorByPhonenumber(ph_number));
	}
	
	@GetMapping("/show/spl/{specialization}")
	public ResponseEntity<Doctorresponse> getDoctorBySpecialitation(@PathVariable String specialization) {
		return ResponseEntity.ok(doctorService.getDoctorBySpecialitation(specialization));
	}
	
	@GetMapping("/show/availablilty/{availablestatus}")
	public ResponseEntity<Doctorresponse> getDoctorByAvaialblity(@PathVariable String availablestatus) {
		return ResponseEntity.ok(doctorService.getDoctorByAvaialblity(availablestatus));
	}
	
	@GetMapping("/show/shift/{shifttype}")
	public ResponseEntity<Doctorresponse> getDoctorByShift(@PathVariable String shifttype) {
		return ResponseEntity.ok(doctorService.getDoctorByShift(shifttype));
	}	

	@PutMapping("/update/{id}")
	public ResponseEntity<Doctorresponse> updateUser(@PathVariable Integer id, @Valid @RequestBody Doctorrequest dto) {
		return ResponseEntity.ok(doctorService.updateUser(id, dto));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, String>> deleteUser(@PathVariable Integer id) {
		doctorService.deleteUser(id);
		Map<String, String> response = new HashMap<>();
		response.put("message", "Doctor id " + id + " is deleted successfully");
		return ResponseEntity.ok(response);
	}
}
