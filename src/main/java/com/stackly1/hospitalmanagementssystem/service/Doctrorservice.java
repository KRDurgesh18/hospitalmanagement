package com.stackly1.hospitalmanagementssystem.service;

import java.util.List;

import com.stackly1.hospitalmanagementssystem.dto.response.Doctorresponse;
import com.stackly1.hospitalmanagementssystem.dto1.request.Doctorrequest;

public interface Doctrorservice {

    Doctorresponse saveDoctor(Doctorrequest request);

    List<Doctorresponse> getAllDoctors();

    Doctorresponse getDoctorById(Long id);

    Doctorresponse updateDoctor(Long id, Doctorrequest request);

    String deleteDoctor(Long id);
}