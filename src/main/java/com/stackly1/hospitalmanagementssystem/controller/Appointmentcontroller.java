package com.stackly1.hospitalmanagementssystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.stackly1.hospitalmanagementssystem.dto.request.Appointmentrequest;
import com.stackly1.hospitalmanagementssystem.dto.response.Appointmentresponse;
import com.stackly1.hospitalmanagementssystem.service.Appointmentservice;

@RestController
@RequestMapping("/appointments")
public class Appointmentcontroller {

    @Autowired
    private Appointmentservice appointmentService;

    // Save Appointment
    @PostMapping("/bookAppointment")
    public Appointmentresponse bookAppointment(
            @RequestBody Appointmentrequest request) {

        return appointmentService
                .saveAppointment(request);
    }

    // Get All Appointments
    @GetMapping("/getAppointments")
    public List<Appointmentresponse> getAppointments() {

        return appointmentService
                .getAllAppointments();
    }

    // Get Appointment By Id
    @GetMapping("/{id}")
    public Appointmentresponse getAppointmentById(
            @PathVariable Integer id) {

        return appointmentService
                .getAppointmentById(id);
    }

    // Update Appointment
    @PutMapping("/update/{id}")
    public Appointmentresponse updateAppointment(
            @PathVariable Integer id,
            @RequestBody Appointmentrequest request) {

        return appointmentService
                .updateAppointment(id, request);
    }

    // Delete Appointment
    @DeleteMapping("/delete/{id}")
    public String deleteAppointment(
            @PathVariable Integer id) {

        return appointmentService
                .deleteAppointment(id);
    }
}