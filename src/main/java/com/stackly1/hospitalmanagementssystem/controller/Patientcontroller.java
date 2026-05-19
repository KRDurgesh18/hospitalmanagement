package com.stackly1.hospitalmanagementssystem.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.stackly1.hospitalmanagementssystem.dto.request.Patientrequest;
import com.stackly1.hospitalmanagementssystem.dto.response.Patientresponse;
import com.stackly1.hospitalmanagementssystem.service.Patientservice;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/patient/V1")
public class Patientcontroller {

    @Autowired
    private Patientservice patientService;

    @PostMapping("/register")
    public Patientresponse registerPatient(@Valid @RequestBody Patientrequest request) {

        return patientService.registerPatient(request);
    }
}