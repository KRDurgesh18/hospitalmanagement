package com.stackly1.hospitalmanagementssystem.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stackly1.hospitalmanagementssystem.dto.request.Doctorrequest;
import com.stackly1.hospitalmanagementssystem.dto.response.Doctorresponse;
import com.stackly1.hospitalmanagementssystem.service.Doctorservice;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
public class Doctorcontroller {

    private final Doctorservice doctorService;

    // =====================================================
    // ADD DOCTOR
    // POST /api/doctors
    // =====================================================
    @PostMapping
    public ResponseEntity<Doctorresponse> addDoctor(
            @RequestBody Doctorrequest doctorrequest) {

        Doctorresponse response =
                doctorService.addDoctor(doctorrequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    // =====================================================
    // GET ALL DOCTORS
    // GET /api/doctors
    // =====================================================
    @GetMapping
    public ResponseEntity<List<Doctorresponse>> getAllDoctors() {

        List<Doctorresponse> doctors =
                doctorService.getAllDoctors();

        return ResponseEntity.ok(doctors);
    }

    // =====================================================
    // GET DOCTOR BY ID
    // GET /api/doctors/{id}
    // =====================================================
    @GetMapping("/{id}")
    public ResponseEntity<Doctorresponse> getDoctorById(
            @PathVariable Long id) {

        Doctorresponse response =
                doctorService.getDoctorById(id);

        return ResponseEntity.ok(response);
    }

    // =====================================================
    // GET DOCTORS BY SPECIALIZATION
    // GET /api/doctors/specialization?type=Cardiology
    // =====================================================
    @GetMapping("/specialization")
    public ResponseEntity<List<Doctorresponse>>
    getDoctorsBySpecialization(
            @RequestParam String type) {

        List<Doctorresponse> doctors =
                doctorService.getDoctorsBySpecialization(type);

        return ResponseEntity.ok(doctors);
    }

    // =====================================================
    // GET AVAILABLE DOCTORS
    // GET /api/doctors/available
    // =====================================================
    @GetMapping("/available")
    public ResponseEntity<List<Doctorresponse>>
    getAvailableDoctors() {

        List<Doctorresponse> doctors =
                doctorService.getAvailableDoctors();

        return ResponseEntity.ok(doctors);
    }

    // =====================================================
    // GET AVAILABLE DOCTORS BY SPECIALIZATION
    // GET /api/doctors/available/specialization?type=Neurology
    // =====================================================
    @GetMapping("/available/specialization")
    public ResponseEntity<List<Doctorresponse>>
    getAvailableDoctorsBySpecialization(
            @RequestParam String type) {

        List<Doctorresponse> doctors =
                doctorService
                        .getAvailableDoctorsBySpecialization(type);

        return ResponseEntity.ok(doctors);
    }

    // =====================================================
    // SEARCH DOCTORS BY NAME
    // GET /api/doctors/search?name=raj
    // =====================================================
    @GetMapping("/search")
    public ResponseEntity<List<Doctorresponse>>
    searchDoctorsByName(
            @RequestParam String name) {

        List<Doctorresponse> doctors =
                doctorService.searchDoctorsByName(name);

        return ResponseEntity.ok(doctors);
    }

    // =====================================================
    // FILTER DOCTORS
    // GET /api/doctors/filter?name=raj
    //                         &specialization=Cardiology
    //                         &available=true
    // All parameters are optional
    // =====================================================
    @GetMapping("/filter")
    public ResponseEntity<List<Doctorresponse>>
    filterDoctors(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String specialization,
            @RequestParam(required = false) Boolean available) {

        List<Doctorresponse> doctors =
                doctorService.filterDoctors(
                        name,
                        specialization,
                        available);

        return ResponseEntity.ok(doctors);
    }

    // =====================================================
    // GET ALL DOCTORS WITH PAGINATION + SORTING
    // GET /api/doctors/paginated?page=0&size=5&sortBy=name
    // =====================================================
    @GetMapping("/paginated")
    public ResponseEntity<Page<Doctorresponse>>
    getAllDoctorsPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy) {

        Page<Doctorresponse> doctors =
                doctorService.getAllDoctorsPaginated(
                        page,
                        size,
                        sortBy);

        return ResponseEntity.ok(doctors);
    }

    // =====================================================
    // GET AVAILABLE DOCTORS WITH PAGINATION
    // GET /api/doctors/available/paginated?page=0&size=5
    // =====================================================
    @GetMapping("/available/paginated")
    public ResponseEntity<Page<Doctorresponse>>
    getAvailableDoctorsPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Page<Doctorresponse> doctors =
                doctorService.getAvailableDoctorsPaginated(
                        page,
                        size);

        return ResponseEntity.ok(doctors);
    }

    // =====================================================
    // GET DOCTORS BY SPECIALIZATION WITH PAGINATION
    // GET /api/doctors/specialization/paginated
    //     ?type=Cardiology&page=0&size=5
    // =====================================================
    @GetMapping("/specialization/paginated")
    public ResponseEntity<Page<Doctorresponse>>
    getDoctorsBySpecializationPaginated(
            @RequestParam String type,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Page<Doctorresponse> doctors =
                doctorService
                        .getDoctorsBySpecializationPaginated(
                                type,
                                page,
                                size);

        return ResponseEntity.ok(doctors);
    }

    // =====================================================
    // GET DOCTORS AVAILABLE ON A SPECIFIC DAY
    // GET /api/doctors/schedule?day=Monday
    // =====================================================
    @GetMapping("/schedule")
    public ResponseEntity<List<Doctorresponse>>
    getDoctorsByAvailableDay(
            @RequestParam String day) {

        List<Doctorresponse> doctors =
                doctorService.getDoctorsByAvailableDay(day);

        return ResponseEntity.ok(doctors);
    }

    // =====================================================
    // UPDATE DOCTOR
    // PUT /api/doctors/{id}
    // =====================================================
    @PutMapping("/{id}")
    public ResponseEntity<Doctorresponse> updateDoctor(
            @PathVariable Long id,
            @RequestBody Doctorrequest doctorrequest) {

        Doctorresponse response =
                doctorService.updateDoctor(
                        id,
                        doctorrequest);

        return ResponseEntity.ok(response);
    }

    // =====================================================
    // UPDATE AVAILABILITY ONLY
    // PATCH /api/doctors/{id}/availability?status=false
    // =====================================================
    @PatchMapping("/{id}/availability")
    public ResponseEntity<Doctorresponse>
    updateAvailability(
            @PathVariable Long id,
            @RequestParam boolean status) {

        Doctorresponse response =
                doctorService.updateAvailability(
                        id,
                        status);

        return ResponseEntity.ok(response);
    }

    // =====================================================
    // DELETE DOCTOR
    // DELETE /api/doctors/{id}
    // =====================================================
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(
            @PathVariable Long id) {

        doctorService.deleteDoctor(id);

        return ResponseEntity.ok(
                "Doctor deleted successfully with id: " + id);
    }
}