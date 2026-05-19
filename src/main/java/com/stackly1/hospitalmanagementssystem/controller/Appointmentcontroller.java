package com.stackly1.hospitalmanagementssystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackly1.hospitalmanagementssystem.dto.request.Appointmentrequest;
import com.stackly1.hospitalmanagementssystem.dto.response.AppointmentResponseDto;
import com.stackly1.hospitalmanagementssystem.service.Appointmentservice;

@RestController
@RequestMapping("/appointments")
public class Appointmentcontroller {

    @Autowired
    private Appointmentservice appointmentService;

    @PostMapping("/bookAppointment")
    public ResponseEntity<AppointmentResponseDto> bookAppointment(@RequestBody Appointmentrequest requestDto) {
        return ResponseEntity.ok(appointmentService.bookAppointment(requestDto));
    }

    @PutMapping("/cancel/{id}")
    public ResponseEntity<AppointmentResponseDto> cancelAppointment(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.cancelAppointment(id));
    }

    @GetMapping("/getAppointments")
    public ResponseEntity<List<AppointmentResponseDto>> getAllAppointments() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<AppointmentResponseDto>> getDoctorAppointments(@PathVariable Long doctorId) {
        return ResponseEntity.ok(appointmentService.getDoctorAppointments(doctorId));
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<AppointmentResponseDto>> getPatientAppointments(@PathVariable Long patientId) {
        return ResponseEntity.ok(appointmentService.getPatientAppointments(patientId));
    }
}