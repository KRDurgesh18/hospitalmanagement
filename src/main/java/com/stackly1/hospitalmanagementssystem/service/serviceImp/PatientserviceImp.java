package com.stackly1.hospitalmanagementssystem.service.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackly1.hospitalmanagementssystem.common.Commonresponse;
import com.stackly1.hospitalmanagementssystem.entity.Patient;
import com.stackly1.hospitalmanagementssystem.exception.ResourceNotFoundException;
import com.stackly1.hospitalmanagementssystem.repository.Patientrepository;
import com.stackly1.hospitalmanagementssystem.service.Patientservice;

@Service
public class PatientserviceImp implements Patientservice {

    @Autowired
    private Patientrepository patientrepository;

    @Override
    public Commonresponse deletePatient(String uid) {

        Patient patient = patientrepository.findByUid(uid)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Patient not found with uid : " + uid));

        patientrepository.delete(patient);

        Commonresponse response = new Commonresponse();

        response.setStatusCode(200);
        response.setMessage("Patient deleted successfully");
        response.setData(null);

        return response;
    }
}