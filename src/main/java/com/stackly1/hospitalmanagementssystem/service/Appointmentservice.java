package com.stackly1.hospitalmanagementssystem.service;

import java.util.List;

import com.stackly1.hospitalmanagementssystem.dto.request.Appointmentrequest;
import com.stackly1.hospitalmanagementssystem.dto.response.AppointmentResponseDto;

public interface Appointmentservice {
    AppointmentResponseDto bookAppointment(Appointmentrequest requestDto);
    AppointmentResponseDto cancelAppointment(Long id);
    List<AppointmentResponseDto> getAllAppointments();
    List<AppointmentResponseDto> getDoctorAppointments(Long doctorId);
    List<AppointmentResponseDto> getPatientAppointments(Long patientId);
}