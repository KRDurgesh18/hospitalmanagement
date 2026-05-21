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
	public ResponseEntity<Commonresponse<List<Doctorresponse>>> getAllDoctors() {

	    List<Doctorresponse> doctors = doctorService.getAllDoctors();

	    Commonresponse<List<Doctorresponse>> response =
	            new Commonresponse<>(
	                    HttpStatus.OK.value(),
	                    "All Doctors fetched successfully",
	                    doctors
	            );

	    return ResponseEntity.ok(response);
	}


	@GetMapping("/show/{id}")
	public ResponseEntity<Commonresponse<Doctorresponse>>
	getDoctorById(@PathVariable Integer id) {

	    Doctorresponse doctor = doctorService.getDoctorById(id);

	    Commonresponse<Doctorresponse> response =
	            new Commonresponse<>(
	                    HttpStatus.OK.value(),
	                    "Doctor fetched successfully by Id",
	                    doctor
	            );

	    return ResponseEntity.ok(response);
	}


	@GetMapping("/show/name/{doctorname}")
	public ResponseEntity<Commonresponse<Doctorresponse>>
	getDoctorByName(@PathVariable String doctorname) {

	    Doctorresponse doctor = doctorService.getDoctorByName(doctorname);

	    Commonresponse<Doctorresponse> response =
	            new Commonresponse<>(
	                    HttpStatus.OK.value(),
	                    "Doctor fetched successfully by doctor name",
	                    doctor
	            );

	    return ResponseEntity.ok(response);
	}


	@GetMapping("/show/mail/{email}")
	public ResponseEntity<Commonresponse<Doctorresponse>>
	getDoctorByMail(@PathVariable String email) {

	    Doctorresponse doctor = doctorService.getDoctorByMail(email);

	    Commonresponse<Doctorresponse> response =
	            new Commonresponse<>(
	                    HttpStatus.OK.value(),
	                    "Doctor fetched successfully by email id",
	                    doctor
	            );

	    return ResponseEntity.ok(response);
	}


	@GetMapping("/show/phone/{ph_number}")
	public ResponseEntity<Commonresponse<Doctorresponse>>
	getDoctorByPhonenumber(@PathVariable String ph_number) {

	    Doctorresponse doctor = doctorService.getDoctorByPhonenumber(ph_number);

	    Commonresponse<Doctorresponse> response =
	            new Commonresponse<>(
	                    HttpStatus.OK.value(),
	                    "Doctor fetched successfully by phone number",
	                    doctor
	            );

	    return ResponseEntity.ok(response);
	}


	@GetMapping("/show/spl/{specialization}")
	public ResponseEntity<Commonresponse<Doctorresponse>>
	getDoctorBySpecialitation(@PathVariable String specialization) {

	    Doctorresponse doctor =
	            doctorService.getDoctorBySpecialitation(specialization);

	    Commonresponse<Doctorresponse> response =
	            new Commonresponse<>(
	                    HttpStatus.OK.value(),
	                    "Doctor fetched successfully by specialization",
	                    doctor
	            );

	    return ResponseEntity.ok(response);
	}


	@GetMapping("/show/availablilty/{availablestatus}")
	public ResponseEntity<Commonresponse<Doctorresponse>>
	getDoctorByAvaialblity(@PathVariable String availablestatus) {

	    Doctorresponse doctor =
	            doctorService.getDoctorByAvaialblity(availablestatus);

	    Commonresponse<Doctorresponse> response =
	            new Commonresponse<>(
	                    HttpStatus.OK.value(),
	                    "Doctor fetched successfully by availablity",
	                    doctor
	            );

	    return ResponseEntity.ok(response);
	}


	@GetMapping("/show/shift/{shifttype}")
	public ResponseEntity<Commonresponse<Doctorresponse>>
	getDoctorByShift(@PathVariable String shifttype) {

	    Doctorresponse doctor =
	            doctorService.getDoctorByShift(shifttype);

	    Commonresponse<Doctorresponse> response =
	            new Commonresponse<>(
	                    HttpStatus.OK.value(),
	                    "Doctor fetched successfully by shift type",
	                    doctor
	            );

	    return ResponseEntity.ok(response);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Commonresponse<Doctorresponse>>
	updateUser(@PathVariable Integer id,
	           @Valid @RequestBody Doctorrequest dto) {

	    Doctorresponse updated = doctorService.updateUser(id, dto);

	    Commonresponse<Doctorresponse> response =
	            new Commonresponse<>(
	                    HttpStatus.OK.value(),
	                    "Doctor Details updated successfully",
	                    updated
	            );

	    return ResponseEntity.ok(response);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, String>> deleteUser(@PathVariable Integer id) {
		doctorService.deleteUser(id);
		Map<String, String> response = new HashMap<>();
		response.put("message", "Doctor id " + id + " is deleted successfully");
		return ResponseEntity.ok(response);
	}
}
