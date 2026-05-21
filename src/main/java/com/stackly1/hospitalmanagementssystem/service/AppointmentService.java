package com.stackly1.hospitalmanagementssystem.service;

import java.util.List;

import com.stackly1.hospitalmanagementssystem.dto.request.Appointmentrequest;
import com.stackly1.hospitalmanagementssystem.dto.response.Appointmentresponse;


public interface AppointmentService {

    List<Appointmentresponse> getAppointmentsByPatientId(int patientId);

    Appointmentresponse bookAppointment(Appointmentrequest request);

    Appointmentresponse cancelAppointment(int id);

    List<Appointmentresponse> getAllAppointments();

    List<Appointmentresponse> getAppointmentsByDoctorId(int doctorId);
}