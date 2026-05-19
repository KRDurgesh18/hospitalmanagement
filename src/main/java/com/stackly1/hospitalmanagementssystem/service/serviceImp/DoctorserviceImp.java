package com.stackly1.hospitalmanagementssystem.service.serviceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackly1.hospitalmanagementssystem.dto1.request.Doctorrequest;
import com.stackly1.hospitalmanagementssystem.dto.response.Doctorresponse;
import com.stackly1.hospitalmanagementssystem.entity.Doctor;
import com.stackly1.hospitalmanagementssystem.repository.Doctorrepository;
import com.stackly1.hospitalmanagementssystem.service.Doctorservice;

@Service
public class DoctorserviceImp implements Doctorservice {

    @Autowired
    private Doctorrepository doctorrepository;

    @Override
    public Doctorresponse addDoctor(Doctorrequest request) {
        Doctor d = new Doctor();
        d.setName(request.getName());
        d.setSpecialization(request.getSpecialization());
        d.setEmail(request.getEmail());
        d.setPhone(request.getPhone());
        d.setDepartment(request.getDepartment());
        Doctor saved = doctorrepository.save(d);
        return mapToResponse(saved);
    }

    @Override
    public List<Doctorresponse> getAllDoctors() {
        return doctorrepository.findAll()
            .stream()
            .map(this::mapToResponse)
            .collect(Collectors.toList());
    }

    @Override
    public Doctorresponse getDoctorById(Long id) {
        Doctor d = doctorrepository.findById(id)
            .orElseThrow(() -> 
                new RuntimeException("Doctor not found"));
        return mapToResponse(d);
    }

    @Override
    public Doctorresponse updateDoctor(Long id, 
                                       Doctorrequest request) {
        Doctor d = doctorrepository.findById(id)
            .orElseThrow(() -> 
                new RuntimeException("Doctor not found"));
        d.setName(request.getName());
        d.setSpecialization(request.getSpecialization());
        d.setEmail(request.getEmail());
        d.setPhone(request.getPhone());
        d.setDepartment(request.getDepartment());
        return mapToResponse(doctorrepository.save(d));
    }

    @Override
    public void deleteDoctor(Long id) {
        doctorrepository.deleteById(id);
    }

    private Doctorresponse mapToResponse(Doctor d) {
        Doctorresponse res = new Doctorresponse();
        res.setId(d.getId());
        res.setName(d.getName());
        res.setSpecialization(d.getSpecialization());
        res.setEmail(d.getEmail());
        res.setPhone(d.getPhone());
        res.setDepartment(d.getDepartment());
        return res;
    }
}