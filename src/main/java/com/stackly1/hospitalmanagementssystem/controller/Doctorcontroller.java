package com.stackly1.hospitalmanagementssystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.stackly1.hospitalmanagementssystem.dto.response.Doctorresponse;
import com.stackly1.hospitalmanagementssystem.dto1.request.Doctorrequest;
import com.stackly1.hospitalmanagementssystem.service.Doctrorservice;

@RestController
@RequestMapping("/doctor")
public class Doctorcontroller {

    @Autowired
    private Doctrorservice service;

    @PostMapping
    public Doctorresponse saveDoctor(@RequestBody Doctorrequest request) {

        return service.saveDoctor(request);
    }

    @GetMapping
    public List<Doctorresponse> getAllDoctors() {

        return service.getAllDoctors();
    }

    @GetMapping("/{id}")
    public Doctorresponse getDoctorById(@PathVariable Long id) {

        return service.getDoctorById(id);
    }

    @PutMapping("/{id}")
    public Doctorresponse updateDoctor(@PathVariable Long id,
                                       @RequestBody Doctorrequest request) {

        return service.updateDoctor(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteDoctor(@PathVariable Long id) {

        return service.deleteDoctor(id);
    }
}