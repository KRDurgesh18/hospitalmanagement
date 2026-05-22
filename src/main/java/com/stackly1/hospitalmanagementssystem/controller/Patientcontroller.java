package com.stackly1.hospitalmanagementssystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackly1.hospitalmanagementssystem.common.Commonresponse;
import com.stackly1.hospitalmanagementssystem.service.Patientservice;

@RestController
@RequestMapping("/patient/v1")
public class Patientcontroller{
	
	  @Autowired
	    private Patientservice patientservice;
	  
	  @DeleteMapping("/{uid}")
	  public Commonresponse deletePatient(@PathVariable String uid) {

	      return patientservice.deletePatient(uid);
	  }
}
	


