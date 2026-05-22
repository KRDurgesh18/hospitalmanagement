package com.stackly1.hospitalmanagementssystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.stackly1.hospitalmanagementssystem.common.Commonresponse;

import com.stackly1.hospitalmanagementssystem.common.Commonresponse;
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
    public Commonresponse bookAppointment(
            @RequestBody Appointmentrequest request) {

        Appointmentresponse appointment =
                appointmentService
                        .saveAppointment(request);

        Commonresponse response =
                new Commonresponse();

        response.setStatuscode("200");
        response.setMessage(
                "Appointment Booked Successfully");
        response.setData(appointment);

        return response;
    }

    // Get All Appointments
    @GetMapping("/getAppointments")
    public Commonresponse getAppointments() {

        List<Appointmentresponse> appointments =
                appointmentService
                        .getAllAppointments();

        Commonresponse response =
                new Commonresponse();

        response.setStatuscode("200");
        response.setMessage(
                "Appointments Fetched Successfully");
        response.setData(appointments);

        return response;
    }

    // Get Appointment By Id
    @GetMapping("/{id}")
    public Commonresponse getAppointmentById(
            @PathVariable Integer id) {

        Appointmentresponse appointment =
                appointmentService
                        .getAppointmentById(id);

        Commonresponse response =
                new Commonresponse();

        response.setStatuscode("200");
        response.setMessage(
                "Appointment Found Successfully");
        response.setData(appointment);

        return response;
    }

    // Update Appointment
    @PutMapping("/update/{id}")
    public Commonresponse updateAppointment(
            @PathVariable Integer id,
            @RequestBody Appointmentrequest request) {

        Appointmentresponse updatedAppointment =
                appointmentService
                        .updateAppointment(id, request);

        Commonresponse response =
                new Commonresponse();

        response.setStatuscode("200");
        response.setMessage(
                "Appointment Updated Successfully");
        response.setData(updatedAppointment);

        return response;
    }

    // Delete Appointment
    @DeleteMapping("/delete/{id}")
    public Commonresponse deleteAppointment(
            @PathVariable Integer id) {

        String message =
                appointmentService
                        .deleteAppointment(id);

        Commonresponse response =
                new Commonresponse();

        response.setStatuscode("200");
        response.setMessage(message);
        response.setData(null);

        return response;
    }
}