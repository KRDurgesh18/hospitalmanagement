package com.stackly1.hospitalmanagementssystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackly1.hospitalmanagementssystem.common.Commonresponse;
import com.stackly1.hospitalmanagementssystem.dto.request.Patientrequest;
import com.stackly1.hospitalmanagementssystem.dto.response.Patientresponse;
import com.stackly1.hospitalmanagementssystem.service.Patientservice;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/patient/v1")
public class Patientcontroller {
	
	@Autowired
	private Patientservice patientService;
	
	@PutMapping("/{uid}")
    public Commonresponse updatePatient(
            @PathVariable String uid,
            @Valid @RequestBody Patientrequest request) {

        return patientService.updatePatient(uid, request);
    }

	

}
