package com.stackly1.hospitalmanagementssystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;
import com.stackly1.hospitalmanagementssystem.dto.request.Appointmentrequest;
import org.springframework.web.bind.annotation.*;

import com.stackly1.hospitalmanagementssystem.common.Commonresponse;
import com.stackly1.hospitalmanagementssystem.entity.Appointment;
import com.stackly1.hospitalmanagementssystem.service.AppointmentService;

@RestController
@RequestMapping("/appointment/v1")
public class Appointmentcontroller {

    @Autowired
    private AppointmentService appointmentService;

    // 1. book appointment
    @PostMapping("/bookAppointment")
    public Commonresponse bookAppointment(
            @RequestBody @Valid Appointmentrequest request){

        Commonresponse response = new Commonresponse();
        response.setStatuscode("200");
        response.setMessage("Appointment booked successfully");
        response.setData(
                appointmentService.bookAppointment(request));

        return response;
    }

    // 2. cancel appointment
    @PutMapping("/cancel/{id}")
    public Commonresponse cancelAppointment(
            @PathVariable int id){

        Commonresponse response = new Commonresponse();
        response.setStatuscode("200");
        response.setMessage("Appointment cancelled successfully");
        response.setData(
                appointmentService.cancelAppointment(id));

        return response;
    }

    // 3. get all appointments
    @GetMapping("/getAppointments")
    public Commonresponse getAllAppointments(){

        Commonresponse response = new Commonresponse();
        response.setStatuscode("200");
        response.setMessage("Appointments fetched successfully");
        response.setData(
                appointmentService.getAllAppointments());

        return response;
    }

    // 4. get doctor appointments
    @GetMapping("/doctor/{doctorId}")
    public Commonresponse getAppointmentsByDoctor(
            @PathVariable int doctorId){

        Commonresponse response = new Commonresponse();
        response.setStatuscode("200");
        response.setMessage(
                "Doctor appointments fetched successfully");
        response.setData(
                appointmentService.getAppointmentsByDoctorId(doctorId));

        return response;
    }

    // 5. get patient appointments
    @GetMapping("/patient/{patientId}")
    public Commonresponse getAppointmentsByPatient(
            @PathVariable int patientId){

        Commonresponse response = new Commonresponse();
        response.setStatuscode("200");
        response.setMessage(
                "Patient appointments fetched successfully");
        response.setData(
                appointmentService.getAppointmentsByPatientId(patientId));

        return response;
    }
}