package com.stackly1.hospitalmanagementssystem.service.serviceImp;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackly1.hospitalmanagementssystem.dto.request.Patientrequest;
import com.stackly1.hospitalmanagementssystem.dto.response.Patientresponse;
import com.stackly1.hospitalmanagementssystem.entity.Patient;
import com.stackly1.hospitalmanagementssystem.repository.Patientrepository;
import com.stackly1.hospitalmanagementssystem.service.Patientservice;
import com.stackly1.hospitalmanagementssystem.exception.EmailAlreadyExistsException;

@Service
public class PatientserviceImp implements Patientservice {

    @Autowired
    private Patientrepository patientrepository;

    @Override
    public Patientresponse registerPatient(Patientrequest request) {

        if (patientrepository.existsByEmail(request.getEmail())) {
        	throw new EmailAlreadyExistsException("Email already exists");
        }

        Patient patient = new Patient();

       // patient.setUid(UUID.randomUUID().toString());
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
        patient.setStatus("ACTIVE");
        patient.setCreatedAt(LocalDateTime.now());
        patient.setUpdatedAt(LocalDateTime.now());

        Patient savedPatient = patientrepository.save(patient);

        Patientresponse response = new Patientresponse();

        response.setId(savedPatient.getId());
        response.setUid(savedPatient.getUid());
        response.setFirstName(savedPatient.getFirstName());
        response.setLastName(savedPatient.getLastName());
        response.setEmail(savedPatient.getEmail());
        response.setPhoneNumber(savedPatient.getPhoneNumber());
        response.setAge(savedPatient.getAge());
        response.setGender(savedPatient.getGender());
        response.setBloodGroup(savedPatient.getBloodGroup());
        response.setAddress(savedPatient.getAddress());
        response.setEmergencyContact(savedPatient.getEmergencyContact());
        response.setStatus(savedPatient.getStatus());

        return response;
    }
}