
package com.stackly1.hospitalmanagementssystem.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.stackly1.hospitalmanagementssystem.dto.request.Doctorrequest;
import com.stackly1.hospitalmanagementssystem.dto.response.Doctorresponse;

public interface Doctorservice {

    // Basic CRUD
    Doctorresponse addDoctor(Doctorrequest doctorrequest);
    List<Doctorresponse> getAllDoctors();
    Doctorresponse getDoctorById(Long id);
    Doctorresponse updateDoctor(Long id, Doctorrequest doctorrequest);
    Doctorresponse updateAvailability(Long id, boolean available);
    void deleteDoctor(Long id);

    // Filter & Search
    List<Doctorresponse> getDoctorsBySpecialization(String specialization);
    List<Doctorresponse> getAvailableDoctors();
    List<Doctorresponse> getAvailableDoctorsBySpecialization(String specialization);
    List<Doctorresponse> searchDoctorsByName(String name);
    List<Doctorresponse> filterDoctors(String name,
                                       String specialization,
                                       Boolean available);

    // Pagination
    Page<Doctorresponse> getAllDoctorsPaginated(int page, int size, String sortBy);
    Page<Doctorresponse> getAvailableDoctorsPaginated(int page, int size);
    Page<Doctorresponse> getDoctorsBySpecializationPaginated(
                                       String specialization, int page, int size);

    // Schedule
    List<Doctorresponse> getDoctorsByAvailableDay(String day);
}