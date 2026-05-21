package com.stackly1.hospitalmanagementssystem.controller;

import com.stackly1.hospitalmanagementssystem.common.Commonresponse;
import com.stackly1.hospitalmanagementssystem.dto1.request.Doctorrequest;
import com.stackly1.hospitalmanagementssystem.dto.response.Doctorresponse;
import com.stackly1.hospitalmanagementssystem.service.Doctorservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class Doctorcontroller {

    @Autowired
    private Doctorservice doctorservice;

    // POST - Add new doctor
    @PostMapping
    public ResponseEntity<Commonresponse<Doctorresponse>> 
                addDoctor(@RequestBody Doctorrequest request) {
        Doctorresponse response = 
                doctorservice.addDoctor(request);
        return ResponseEntity.ok(
            Commonresponse.success(
                "Doctor added successfully", response));
    }

    // GET - Get all doctors
    @GetMapping
    public ResponseEntity<Commonresponse<List<Doctorresponse>>> 
                getAllDoctors() {
        List<Doctorresponse> response = 
                doctorservice.getAllDoctors();
        return ResponseEntity.ok(
            Commonresponse.success(
                "Doctors fetched successfully", response));
    }

    // GET - Get doctor by ID
    @GetMapping("/{id}")
    public ResponseEntity<Commonresponse<Doctorresponse>> 
                getDoctorById(@PathVariable Long id) {
        Doctorresponse response = 
                doctorservice.getDoctorById(id);
        return ResponseEntity.ok(
            Commonresponse.success(
                "Doctor fetched successfully", response));
    }

    // PUT - Update doctor
    @PutMapping("/{id}")
    public ResponseEntity<Commonresponse<Doctorresponse>> 
                updateDoctor(@PathVariable Long id,
                @RequestBody Doctorrequest request) {
        Doctorresponse response = 
                doctorservice.updateDoctor(id, request);
        return ResponseEntity.ok(
            Commonresponse.success(
                "Doctor updated successfully", response));
    }

    // DELETE - Delete doctor
    @DeleteMapping("/{id}")
    public ResponseEntity<Commonresponse<String>> 
                deleteDoctor(@PathVariable Long id) {
        doctorservice.deleteDoctor(id);
        return ResponseEntity.ok(
            Commonresponse.success(
                "Doctor deleted successfully", 
                "Doctor with id " + id + " deleted"));
    }
}