package com.stackly1.hospitalmanagementssystem.service.serviceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackly1.hospitalmanagementssystem.common.Commonresponse;
import com.stackly1.hospitalmanagementssystem.dto.response.Patientresponse;
import com.stackly1.hospitalmanagementssystem.entity.Patient;
import com.stackly1.hospitalmanagementssystem.exception.PatientNotFoundException;
import com.stackly1.hospitalmanagementssystem.repository.Patientrepository;
import com.stackly1.hospitalmanagementssystem.service.Patientservice;

@Service
public class PatientserviceImp implements Patientservice {

    @Autowired
    private Patientrepository patientrepository;

    @Override
    public Commonresponse getAllPatients() {

        List<Patient> patients = patientrepository.findAll();

        List<Patientresponse> responseList = new ArrayList<>();

        for (Patient patient : patients) {

            Patientresponse response = new Patientresponse();

            response.setId(patient.getId());
            response.setUid(patient.getUid());
            response.setFirstName(patient.getFirstName());
            response.setLastName(patient.getLastName());
            response.setEmail(patient.getEmail());
            response.setPhoneNumber(patient.getPhoneNumber());
            response.setAge(patient.getAge());
            response.setGender(patient.getGender());
            response.setBloodGroup(patient.getBloodGroup());
            response.setAddress(patient.getAddress());
            response.setEmergencyContact(patient.getEmergencyContact());
            response.setStatus(patient.getStatus());

            responseList.add(response);
        }

        Commonresponse commonresponse = new Commonresponse();

        commonresponse.setStatuscode("200");
        commonresponse.setMessage("Patients fetched successfully");
        commonresponse.setData(responseList);

        return commonresponse;
    }

	@Override
	public Commonresponse getPatientByUid(String uid) {
		
	    Optional<Patient> optionalPatient = patientrepository.findByUid(uid);

	    if (optionalPatient.isEmpty()) {
	        throw new PatientNotFoundException(
	                "Patient not found with UID : " + uid);
	    }

	    Patient patient = optionalPatient.get();

	    Patientresponse response = new Patientresponse();

	    response.setId(patient.getId());
	    response.setUid(patient.getUid());
	    response.setFirstName(patient.getFirstName());
	    response.setLastName(patient.getLastName());
	    response.setEmail(patient.getEmail());
	    response.setPhoneNumber(patient.getPhoneNumber());
	    response.setAge(patient.getAge());
	    response.setGender(patient.getGender());
	    response.setBloodGroup(patient.getBloodGroup());
	    response.setAddress(patient.getAddress());
	    response.setEmergencyContact(patient.getEmergencyContact());
	    response.setStatus(patient.getStatus());

	    Commonresponse commonresponse = new Commonresponse();

	    commonresponse.setStatuscode("200");
	    commonresponse.setMessage("Patient fetched successfully");
	    commonresponse.setData(response);

	    return commonresponse;
	}
}
