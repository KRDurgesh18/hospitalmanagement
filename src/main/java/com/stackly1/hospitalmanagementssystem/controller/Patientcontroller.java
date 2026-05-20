package com.stackly1.hospitalmanagementssystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackly1.hospitalmanagementssystem.common.Commonresponse;
import com.stackly1.hospitalmanagementssystem.service.Patientservice;

@RestController
@RequestMapping("/patient/v1")
public class Patientcontroller {

    @Autowired
    private Patientservice patientservice;

    @GetMapping("/all")
    public Commonresponse getAllPatients() {

        return patientservice.getAllPatients();
    }
    
    @GetMapping("/uid/{uid}")
    public Commonresponse getPatientByUid(
            @PathVariable String uid) {

        return patientservice.getPatientByUid(uid);
    }
}
