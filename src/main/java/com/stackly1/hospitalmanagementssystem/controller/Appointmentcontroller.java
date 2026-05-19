package com.stackly1.hospitalmanagementssystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.stackly1.hospitalmanagementssystem.entity.Appointment;
import com.stackly1.hospitalmanagementssystem.service.AppointmentService;

@RestController
@RequestMapping("/appointment/v1")
public class Appointmentcontroller {

    @Autowired
    private AppointmentService appointmentService;


    // 1. book appointment
    @PostMapping("/bookAppointment")
    public Appointment bookAppointment(
            @RequestBody Appointment appointment){

        return appointmentService.bookAppointment(appointment);
    }


    // 2. cancel appointment
    @PutMapping("/cancel/{id}")
    public Appointment cancelAppointment(
            @PathVariable int id){

        return appointmentService.cancelAppointment(id);
    }


    // 3. get all appointments
    @GetMapping("/getAppointments")
    public List<Appointment> getAllAppointments(){

        return appointmentService.getAllAppointments();
    }


    // 4. get doctor appointments
    @GetMapping("/doctor/{doctorId}")
    public List<Appointment> getAppointmentsByDoctor(
            @PathVariable int doctorId){

        return appointmentService.getAppointmentsByDoctorId(doctorId);
    }


    // existing
    @GetMapping("/patient/{patientId}")
    public List<Appointment> getAppointmentsByPatient(
            @PathVariable int patientId){

        return appointmentService.getAppointmentsByPatientId(patientId);
    }
}