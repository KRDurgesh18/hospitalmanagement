package com.stackly1.hospitalmanagementssystem.service;

import java.util.List;

import com.stackly1.hospitalmanagementssystem.dto.request.Appointmentrequest;
import com.stackly1.hospitalmanagementssystem.dto.response.Appointmentresponse;

public interface Appointmentservice {

    Appointmentresponse saveAppointment(
            Appointmentrequest request);

    List<Appointmentresponse> getAllAppointments();

    Appointmentresponse getAppointmentById(
            Integer appointmentId);

    Appointmentresponse updateAppointment(
            Integer appointmentId,
            Appointmentrequest request);

    String deleteAppointment(
            Integer appointmentId);
}
