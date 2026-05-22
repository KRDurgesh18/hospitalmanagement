package com.stackly1.hospitalmanagementssystem.service.serviceImp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackly1.hospitalmanagementssystem.common.Commonresponse;
import com.stackly1.hospitalmanagementssystem.dto.request.Appointmentrequest;
import com.stackly1.hospitalmanagementssystem.dto.response.Appointmentresponse;
import com.stackly1.hospitalmanagementssystem.entity.Appointment;
import com.stackly1.hospitalmanagementssystem.entity.Doctor;
import com.stackly1.hospitalmanagementssystem.entity.Patient;
import com.stackly1.hospitalmanagementssystem.exception.ResourceNotFoundException;
import com.stackly1.hospitalmanagementssystem.repository.Appointmentrepository;
import com.stackly1.hospitalmanagementssystem.repository.Doctorrepository;
import com.stackly1.hospitalmanagementssystem.repository.Patientrepository;
import com.stackly1.hospitalmanagementssystem.service.Appointmentservice;
import jakarta.transaction.Transactional;

@Service
public class AppointmentserviceImp implements Appointmentservice {

	@Autowired
	private Appointmentrepository appointmentrepository;

	@Autowired
	private Doctorrepository doctorrepository;

	@Autowired
	private Patientrepository patientrepository;

//	@Override
//	@Transactional
//	public Object saveAppointment(Appointmentrequest appointmentrequest) {
//
//		Doctor doctor = doctorrepository.findById(appointmentrequest.getDoctorId()).orElse(null);
//
//		Patient patient = patientrepository.findById(appointmentrequest.getPatientId()).orElse(null);
//
//		if (appointmentrequest.getDoctorId() == null || appointmentrequest.getPatientId() == null) {
//			return "Doctor and Patient must not be null";
//		}
//
//		if (appointmentrequest.getAppointmentDate().isBefore(LocalDate.now())) {
//			return "Appointment date cannot be in the past";
//		} else {
//			Appointment appointment = new Appointment();
//			appointment.setStatus(appointmentrequest.getStatus());
//			appointment.setDoctor_id(doctor);
//			appointment.setPatient_id(patient);
//			appointment.setAppointment_date(appointmentrequest.getAppointmentDate());
//			appointmentrepository.save(appointment);
//		}
//		return "Appointment details saved successfully";
//
//	}

	@Override
	public Commonresponse<?> saveAppointment(Appointmentrequest appointmentrequest) throws BadRequestException {

		if (appointmentrequest.getDoctorId() == null || appointmentrequest.getPatientId() == null) {

			throw new BadRequestException("Doctor and Patient must not be null");
		}

		Doctor doctor = doctorrepository.findById(appointmentrequest.getDoctorId())
				.orElseThrow(() -> new ResourceNotFoundException("Doctor not found"));

		Patient patient = patientrepository.findById(appointmentrequest.getPatientId())
				.orElseThrow(() -> new ResourceNotFoundException("Patient not found"));

		if (appointmentrequest.getAppointmentDate().isBefore(LocalDate.now())) {

			throw new BadRequestException("Appointment date cannot be in the past");
		}

		Appointment appointment = new Appointment();
		appointment.setStatus(appointmentrequest.getStatus());
		appointment.setDoctor_id(doctor);
		appointment.setPatient_id(patient);
		appointment.setAppointment_date(appointmentrequest.getAppointmentDate());
		appointmentrepository.save(appointment);

		return new Commonresponse<>(true, "Appointment details saved successfully", appointment);
	}

	@Override
	@Transactional
	public Object deleteAppointmentById(Integer id) {

		Appointment appointment = appointmentrepository.findById(id).orElse(null);

		if (appointment == null) {
			return "Appointment not found";
		}

		appointmentrepository.deleteById(id);

		return "Appointment deleted successfully";
	}

	@Override
	public Object getAllAppointment() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<Appointment> appointment = appointmentrepository.findAll();

		for (Appointment a : appointment) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("appointmentId", a.getId());
			map.put("status", a.getStatus());
			map.put("appointmentDate", a.getAppointment_date());
			map.put("patientId", a.getPatient_id());
			map.put("doctorId", a.getDoctor_id());
			list.add(map);
		}

		return list;
	}

	@Override
	public Object getAppointmentsByPatientId(Integer appointmentPatientId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Appointment appointment = appointmentrepository.findById(appointmentPatientId).orElse(null);
		if (appointment != null) {
			map.put("appointmentId", appointment.getId());
			map.put("status", appointment.getStatus());
			map.put("appointmentDate", appointment.getAppointment_date());
			map.put("patientId", appointment.getPatient_id());
			map.put("doctorId", appointment.getDoctor_id());
		}
		return map;
	}

	@Override
	public Object getAppointmentsByDoctor(Integer doctorId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Appointment appointment = appointmentrepository.findById(doctorId).orElse(null);
		if (appointment != null) {
			map.put("appointmentId", appointment.getId());
			map.put("status", appointment.getStatus());
			map.put("appointmentDate", appointment.getAppointment_date());
			map.put("patientId", appointment.getPatient_id());
			map.put("doctorId", appointment.getDoctor_id());
		}
		return map;
	}

}
