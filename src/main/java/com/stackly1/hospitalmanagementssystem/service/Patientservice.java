package com.stackly1.hospitalmanagementssystem.service;


import com.stackly1.hospitalmanagementssystem.dto.request.Patientrequest;
import com.stackly1.hospitalmanagementssystem.dto.response.Patientresponse;
public interface Patientservice {

    Patientresponse registerPatient(Patientrequest request);
}