package com.stackly1.hospitalmanagementssystem.service.serviceImp;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.stackly1.hospitalmanagementssystem.dto.request.Doctorrequest;
import com.stackly1.hospitalmanagementssystem.dto.response.Doctorresponse;
import com.stackly1.hospitalmanagementssystem.entity.Doctor;
import com.stackly1.hospitalmanagementssystem.exception.ResourceNotFoundException;
import com.stackly1.hospitalmanagementssystem.repository.Doctorrepository;
import com.stackly1.hospitalmanagementssystem.service.Doctorservice;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DoctorserviceImp implements Doctorservice {

    private final Doctorrepository doctorRepository;

    // =========================
    // ADD DOCTOR
    // =========================
    @Override
    public Doctorresponse addDoctor(Doctorrequest doctorrequest) {

        if (doctorRepository.findByEmail(doctorrequest.getEmail()).isPresent()) {
            throw new RuntimeException(
                    "Doctor already exists with email: " + doctorrequest.getEmail());
        }

        if (doctorRepository.findByPhone(doctorrequest.getPhone()).isPresent()) {
            throw new RuntimeException(
                    "Doctor already exists with phone: " + doctorrequest.getPhone());
        }

        Doctor doctor = mapToEntity(doctorrequest);
        Doctor savedDoctor = doctorRepository.save(doctor);

        return mapToResponse(savedDoctor);
    }

    // =========================
    // GET ALL DOCTORS
    // =========================
    @Override
    public List<Doctorresponse> getAllDoctors() {
        return doctorRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // =========================
    // GET DOCTOR BY ID
    // =========================
    @Override
    public Doctorresponse getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Doctor not found with id: " + id));

        return mapToResponse(doctor);
    }

    // =========================
    // UPDATE DOCTOR
    // =========================
    @Override
    public Doctorresponse updateDoctor(Long id, Doctorrequest doctorrequest) {

        Doctor existingDoctor = doctorRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Doctor not found with id: " + id));

        // Check duplicate email
        doctorRepository.findByEmail(doctorrequest.getEmail())
                .ifPresent(doctor -> {
                    if (!doctor.getId().equals(id)) {
                        throw new RuntimeException(
                                "Email already in use: " + doctorrequest.getEmail());
                    }
                });

        // Check duplicate phone
        doctorRepository.findByPhone(doctorrequest.getPhone())
                .ifPresent(doctor -> {
                    if (!doctor.getId().equals(id)) {
                        throw new RuntimeException(
                                "Phone already in use: " + doctorrequest.getPhone());
                    }
                });

        // Update basic fields
        existingDoctor.setName(doctorrequest.getName());
        existingDoctor.setSpecialization(doctorrequest.getSpecialization());
        existingDoctor.setEmail(doctorrequest.getEmail());
        existingDoctor.setPhone(doctorrequest.getPhone());
        existingDoctor.setQualification(doctorrequest.getQualification());
        existingDoctor.setAvailable(doctorrequest.isAvailable());

        // Update schedule fields
        existingDoctor.setStartTime(doctorrequest.getStartTime());
        existingDoctor.setEndTime(doctorrequest.getEndTime());
        existingDoctor.setAvailableDays(doctorrequest.getAvailableDays());

        Doctor updatedDoctor = doctorRepository.save(existingDoctor);

        return mapToResponse(updatedDoctor);
    }

    // =========================
    // UPDATE AVAILABILITY
    // =========================
    @Override
    public Doctorresponse updateAvailability(Long id, boolean available) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Doctor not found with id: " + id));

        doctor.setAvailable(available);

        Doctor updatedDoctor = doctorRepository.save(doctor);

        return mapToResponse(updatedDoctor);
    }

    // =========================
    // DELETE DOCTOR
    // =========================
    @Override
    public void deleteDoctor(Long id) {
        if (!doctorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Doctor not found with id: " + id);
        }

        doctorRepository.deleteById(id);
    }

    // =========================
    // FILTER & SEARCH
    // =========================
    @Override
    public List<Doctorresponse> getDoctorsBySpecialization(String specialization) {
        List<Doctor> doctors =
                doctorRepository.findBySpecialization(specialization);

        if (doctors.isEmpty()) {
            throw new ResourceNotFoundException(
                    "No doctors found with specialization: " + specialization);
        }

        return doctors.stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public List<Doctorresponse> getAvailableDoctors() {
        return doctorRepository.findByAvailableTrue()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public List<Doctorresponse> getAvailableDoctorsBySpecialization(
            String specialization) {

        List<Doctor> doctors =
                doctorRepository.findBySpecializationAndAvailableTrue(
                        specialization);

        if (doctors.isEmpty()) {
            throw new ResourceNotFoundException(
                    "No available doctors found for: " + specialization);
        }

        return doctors.stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public List<Doctorresponse> searchDoctorsByName(String name) {
        List<Doctor> doctors =
                doctorRepository.findByNameContainingIgnoreCase(name);

        if (doctors.isEmpty()) {
            throw new ResourceNotFoundException(
                    "No doctors found with name containing: " + name);
        }

        return doctors.stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public List<Doctorresponse> filterDoctors(
            String name,
            String specialization,
            Boolean available) {

        List<Doctor> doctors = doctorRepository.findAll();

        return doctors.stream()
                .filter(doctor ->
                        name == null || name.isBlank() ||
                        doctor.getName().toLowerCase()
                                .contains(name.toLowerCase()))
                .filter(doctor ->
                        specialization == null ||
                        specialization.isBlank() ||
                        doctor.getSpecialization()
                                .equalsIgnoreCase(specialization))
                .filter(doctor ->
                        available == null ||
                        doctor.isAvailable() == available)
                .map(this::mapToResponse)
                .toList();
    }

    // =========================
    // PAGINATION
    // =========================
    @Override
    public Page<Doctorresponse> getAllDoctorsPaginated(
            int page,
            int size,
            String sortBy) {

        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(sortBy).ascending());

        return doctorRepository.findAll(pageable)
                .map(this::mapToResponse);
    }

    @Override
    public Page<Doctorresponse> getAvailableDoctorsPaginated(
            int page,
            int size) {

        Pageable pageable = PageRequest.of(page, size);

        return doctorRepository.findByAvailableTrue(pageable)
                .map(this::mapToResponse);
    }

    @Override
    public Page<Doctorresponse> getDoctorsBySpecializationPaginated(
            String specialization,
            int page,
            int size) {

        Pageable pageable = PageRequest.of(page, size);

        return doctorRepository
                .findBySpecialization(specialization, pageable)
                .map(this::mapToResponse);
    }

    // =========================
    // SCHEDULE
    // =========================
    @Override
    public List<Doctorresponse> getDoctorsByAvailableDay(String day) {
        List<Doctor> doctors =
                doctorRepository.findByAvailableDaysContainingIgnoreCase(day);

        if (doctors.isEmpty()) {
            throw new ResourceNotFoundException(
                    "No doctors available on: " + day);
        }

        return doctors.stream()
                .map(this::mapToResponse)
                .toList();
    }

    // =========================
    // DTO -> ENTITY
    // =========================
    private Doctor mapToEntity(Doctorrequest dto) {
        Doctor doctor = new Doctor();

        doctor.setName(dto.getName());
        doctor.setSpecialization(dto.getSpecialization());
        doctor.setEmail(dto.getEmail());
        doctor.setPhone(dto.getPhone());
        doctor.setQualification(dto.getQualification());
        doctor.setAvailable(dto.isAvailable());

        // Schedule fields
        doctor.setStartTime(dto.getStartTime());
        doctor.setEndTime(dto.getEndTime());
        doctor.setAvailableDays(dto.getAvailableDays());

        return doctor;
    }

    // =========================
    // ENTITY -> RESPONSE DTO
    // =========================
    private Doctorresponse mapToResponse(Doctor doctor) {
        Doctorresponse dto = new Doctorresponse();

        dto.setId(doctor.getId());
        dto.setName(doctor.getName());
        dto.setSpecialization(doctor.getSpecialization());
        dto.setEmail(doctor.getEmail());
        dto.setPhone(doctor.getPhone());
        dto.setQualification(doctor.getQualification());
        dto.setAvailable(doctor.isAvailable());

        // Schedule fields
        dto.setStartTime(doctor.getStartTime());
        dto.setEndTime(doctor.getEndTime());
        dto.setAvailableDays(doctor.getAvailableDays());

        return dto;
    }
}