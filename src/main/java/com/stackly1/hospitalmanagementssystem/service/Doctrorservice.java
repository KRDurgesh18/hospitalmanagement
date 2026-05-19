package com.stackly1.hospitalmanagementssystem.service;

import com.stackly1.hospitalmanagementssystem.dto1.request.Doctorrequest;
import com.stackly1.hospitalmanagementssystem.dto.response.Doctorresponse;
import java.util.List;

public interface Doctorservice {
    Doctorresponse addDoctor(Doctorrequest request);
    List<Doctorresponse> getAllDoctors();
    Doctorresponse getDoctorById(Long id);
    Doctorresponse updateDoctor(Long id, Doctorrequest request);
    void deleteDoctor(Long id);
}