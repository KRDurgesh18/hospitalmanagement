package com.stackly1.hospitalmanagementssystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackly1.hospitalmanagementssystem.common.Commonresponse;
import com.stackly1.hospitalmanagementssystem.dto.request.Appointmentrequest;
import com.stackly1.hospitalmanagementssystem.dto.response.AppointmentResponseDto;
import com.stackly1.hospitalmanagementssystem.service.Appointmentservice;

@RestController
@RequestMapping("/appointments")
public class Appointmentcontroller {

    @Autowired
    private Appointmentservice appointmentService;

    @PostMapping("/bookAppointment")
    public ResponseEntity<Commonresponse<AppointmentResponseDto>> bookAppointment(@RequestBody Appointmentrequest requestDto) {
        AppointmentResponseDto data = appointmentService.bookAppointment(requestDto);
        return new ResponseEntity<>(Commonresponse.success("Appointment booked successfully", data), HttpStatus.CREATED);
    }

    @PutMapping("/cancel/{id}")
    public ResponseEntity<Commonresponse<AppointmentResponseDto>> cancelAppointment(@PathVariable Long id) {
        AppointmentResponseDto data = appointmentService.cancelAppointment(id);
        return ResponseEntity.ok(Commonresponse.success("Appointment cancelled successfully", data));
    }

    @GetMapping("/getAppointments")
    public ResponseEntity<Commonresponse<List<AppointmentResponseDto>>> getAllAppointments() {
        List<AppointmentResponseDto> data = appointmentService.getAllAppointments();
        return ResponseEntity.ok(Commonresponse.success("All appointments retrieved successfully", data));
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<Commonresponse<List<AppointmentResponseDto>>> getDoctorAppointments(@PathVariable Long doctorId) {
        List<AppointmentResponseDto> data = appointmentService.getDoctorAppointments(doctorId);
        return ResponseEntity.ok(Commonresponse.success("Doctor appointments retrieved successfully", data));
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<Commonresponse<List<AppointmentResponseDto>>> getPatientAppointments(@PathVariable Long patientId) {
        List<AppointmentResponseDto> data = appointmentService.getPatientAppointments(patientId);
        return ResponseEntity.ok(Commonresponse.success("Patient appointments retrieved successfully", data));
    }
}