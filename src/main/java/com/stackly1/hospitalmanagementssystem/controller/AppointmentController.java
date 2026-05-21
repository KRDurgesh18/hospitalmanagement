package com.stackly1.hospitalmanagementssystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackly1.hospitalmanagementssystem.common.CommonResponse;
import com.stackly1.hospitalmanagementssystem.dto.AppointmentDTO;
import com.stackly1.hospitalmanagementssystem.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<CommonResponse<List<AppointmentDTO>>> getDoctorAppointments(@PathVariable int doctorId) {
        List<AppointmentDTO> appointments = appointmentService.getAppointmentsByDoctor(doctorId);
        
        CommonResponse<List<AppointmentDTO>> response = CommonResponse.success(
            appointments, 
            "Successfully retrieved appointments for doctor ID: " + doctorId
        );
        
        return ResponseEntity.ok(response);
    }
}