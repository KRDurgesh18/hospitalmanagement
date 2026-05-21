package com.stackly1.hospitalmanagementssystem.service.serviceImp;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackly1.hospitalmanagementssystem.common.Commonresponse;
import com.stackly1.hospitalmanagementssystem.dto.request.Patientrequest;
import com.stackly1.hospitalmanagementssystem.dto.response.Patientresponse;
import com.stackly1.hospitalmanagementssystem.entity.Patient;
import com.stackly1.hospitalmanagementssystem.repository.Patientrepository;
import com.stackly1.hospitalmanagementssystem.service.Patientservice;

@Service
public class PatientserviceImp implements Patientservice {
	@Autowired
	private Patientrepository patientrepository;

	@Override
	public Commonresponse updatePatient(
			String uid,
			Patientrequest request) {

		Patient patient = patientrepository.findByUid(uid)
				.orElseThrow(() ->
				new RuntimeException(
						"Patient not found with id : " + uid));

		patient.setFirstName(request.getFirstName());
		patient.setLastName(request.getLastName());
		patient.setEmail(request.getEmail());
		patient.setPhoneNumber(request.getPhoneNumber());
		patient.setPassword(request.getPassword());
		patient.setAge(request.getAge());
		patient.setGender(request.getGender());
		patient.setBloodGroup(request.getBloodGroup());
		patient.setAddress(request.getAddress());
		patient.setEmergencyContact(request.getEmergencyContact());
		patient.setUpdatedAt(LocalDateTime.now());

		Patient updatedPatient = patientrepository.save(patient);

		Patientresponse response = new Patientresponse();

		response.setId(updatedPatient.getId());
		response.setUid(updatedPatient.getUid());
		response.setFirstName(updatedPatient.getFirstName());
		response.setLastName(updatedPatient.getLastName());
		response.setEmail(updatedPatient.getEmail());
		response.setPhoneNumber(updatedPatient.getPhoneNumber());
		response.setAge(updatedPatient.getAge());
		response.setGender(updatedPatient.getGender());
		response.setBloodGroup(updatedPatient.getBloodGroup());
		response.setAddress(updatedPatient.getAddress());
		response.setEmergencyContact(updatedPatient.getEmergencyContact());
		response.setStatus(updatedPatient.getStatus());

		Commonresponse commonresponse =
				new Commonresponse();

		commonresponse.setStatuscode("200");
		commonresponse.setMessage(
				"Patient updated successfully");
		commonresponse.setData(response);

		return commonresponse;
	}
}      

