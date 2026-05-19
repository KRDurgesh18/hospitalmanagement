package com.stackly1.hospitalmanagementssystem.service.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackly1.hospitalmanagementssystem.dto.response.Doctorresponse;
import com.stackly1.hospitalmanagementssystem.dto1.request.Doctorrequest;
import com.stackly1.hospitalmanagementssystem.entity.Doctor;
import com.stackly1.hospitalmanagementssystem.repository.Doctorrepository;
import com.stackly1.hospitalmanagementssystem.service.Doctrorservice;

@Service
public class DoctorserviceImp implements Doctrorservice {

    @Autowired
    private Doctorrepository repository;

    @Override
    public Doctorresponse saveDoctor(Doctorrequest request) {

        Doctor doctor = new Doctor();

        doctor.setDoctorName(request.getDoctorName());
        doctor.setSpecialization(request.getSpecialization());
        doctor.setPhoneNumber(request.getPhoneNumber());
        doctor.setEmail(request.getEmail());
        doctor.setExperience(request.getExperience());
        doctor.setQualification(request.getQualification());
        doctor.setGender(request.getGender());
        doctor.setConsultationFee(request.getConsultationFee());
        doctor.setAvailability(request.getAvailability());
        doctor.setDepartment(request.getDepartment());
        doctor.setHospitalName(request.getHospitalName());
        doctor.setAddress(request.getAddress());

        Doctor savedDoctor = repository.save(doctor);

        return mapToResponse(savedDoctor);
    }

    @Override
    public List<Doctorresponse> getAllDoctors() {

        List<Doctor> doctors = repository.findAll();

        List<Doctorresponse> responses = new ArrayList<>();

        for (Doctor doctor : doctors) {
            responses.add(mapToResponse(doctor));
        }

        return responses;
    }

    @Override
    public Doctorresponse getDoctorById(Long id) {

        Doctor doctor = repository.findById(id).orElse(null);

        return mapToResponse(doctor);
    }

    @Override
    public Doctorresponse updateDoctor(Long id, Doctorrequest request) {

        Doctor doctor = repository.findById(id).orElse(null);

        if (doctor != null) {

            doctor.setDoctorName(request.getDoctorName());
            doctor.setSpecialization(request.getSpecialization());
            doctor.setPhoneNumber(request.getPhoneNumber());
            doctor.setEmail(request.getEmail());
            doctor.setExperience(request.getExperience());
            doctor.setQualification(request.getQualification());
            doctor.setGender(request.getGender());
            doctor.setConsultationFee(request.getConsultationFee());
            doctor.setAvailability(request.getAvailability());
            doctor.setDepartment(request.getDepartment());
            doctor.setHospitalName(request.getHospitalName());
            doctor.setAddress(request.getAddress());

            Doctor updatedDoctor = repository.save(doctor);

            return mapToResponse(updatedDoctor);
        }

        return null;
    }

    @Override
    public String deleteDoctor(Long id) {

        repository.deleteById(id);

        return "Doctor deleted successfully";
    }

    private Doctorresponse mapToResponse(Doctor doctor) {

        Doctorresponse response = new Doctorresponse();

        response.setId(doctor.getId());
        response.setDoctorName(doctor.getDoctorName());
        response.setSpecialization(doctor.getSpecialization());
        response.setPhoneNumber(doctor.getPhoneNumber());
        response.setEmail(doctor.getEmail());
        response.setExperience(doctor.getExperience());
        response.setQualification(doctor.getQualification());
        response.setGender(doctor.getGender());
        response.setConsultationFee(doctor.getConsultationFee());
        response.setAvailability(doctor.getAvailability());
        response.setDepartment(doctor.getDepartment());
        response.setHospitalName(doctor.getHospitalName());
        response.setAddress(doctor.getAddress());

        return response;
    }
}