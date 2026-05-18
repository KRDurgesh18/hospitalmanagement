package com.stackly1.hospitalmanagementssystem.service;

import com.stackly1.hospitalmanagementssystem.dto.request.AppointmentDeleterequest;
import com.stackly1.hospitalmanagementssystem.dto.request.AppointmentPatientId;
import com.stackly1.hospitalmanagementssystem.dto.request.Appointmentrequest;

public interface Appointmentservice {

	Object saveAppointment(Appointmentrequest appointmentrequest);

	Object deleteAppointmentById(Integer id);

	Object getAllAppointment();

	Object getAppointmentsByPatientId(Integer appointmentPatientId);

	Object getAppointmentsByDoctor(Integer doctorId);



}
