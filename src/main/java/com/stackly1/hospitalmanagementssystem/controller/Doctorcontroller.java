package com.stackly1.hospitalmanagementssystem.controller;

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

    @PostMapping
    public ResponseEntity<Doctorresponse> addDoctor(
            @RequestBody Doctorrequest request) {
        return ResponseEntity.ok(doctorservice.addDoctor(request));
    }

    @GetMapping
    public ResponseEntity<List<Doctorresponse>> getAllDoctors() {
        return ResponseEntity.ok(doctorservice.getAllDoctors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctorresponse> getDoctorById(
            @PathVariable Long id) {
        return ResponseEntity.ok(doctorservice.getDoctorById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctorresponse> updateDoctor(
            @PathVariable Long id,
            @RequestBody Doctorrequest request) {
        return ResponseEntity.ok(doctorservice.updateDoctor(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(
            @PathVariable Long id) {
        doctorservice.deleteDoctor(id);
        return ResponseEntity.ok("Doctor deleted successfully");
    }
}