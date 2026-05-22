package com.stackly1.hospitalmanagementssystem.service;

import org.apache.coyote.BadRequestException;

import com.stackly1.hospitalmanagementssystem.common.Commonresponse;
import com.stackly1.hospitalmanagementssystem.dto.request.AppointmentDeleterequest;
import com.stackly1.hospitalmanagementssystem.dto.request.AppointmentPatientId;
import com.stackly1.hospitalmanagementssystem.dto.request.Appointmentrequest;

public interface Appointmentservice {

//	Commonresponse<?> saveAppointment(Appointmentrequest appointmentrequest);

	Object saveAppointment(Appointmentrequest appointmentrequest) throws BadRequestException;
	
	Object deleteAppointmentById(Integer id);

	Object getAllAppointment();

	Object getAppointmentsByPatientId(Integer appointmentPatientId);

	Object getAppointmentsByDoctor(Integer doctorId);



}
