package com.stackly1.hospitalmanagementssystem.controller;

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

import com.stackly1.hospitalmanagementssystem.common.Commonresponse;
import com.stackly1.hospitalmanagementssystem.dto.request.Doctorrequest;
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
    // SUCCESS  → 201 Created
    // FAIL     → 400 Bad Request (duplicate email/phone)
    // =====================================================
    @PostMapping
    public ResponseEntity<Commonresponse> addDoctor(
            @RequestBody Doctorrequest doctorrequest) {

        return ResponseEntity
                .status(HttpStatus.CREATED)         // 201
                .body(Commonresponse.created(
                        "Doctor added successfully",
                        doctorService.addDoctor(doctorrequest)));
    }

    // =====================================================
    // GET ALL DOCTORS
    // GET /api/doctors
    // SUCCESS → 200 OK
    // =====================================================
    @GetMapping
    public ResponseEntity<Commonresponse> getAllDoctors() {

        return ResponseEntity
                .status(HttpStatus.OK)              // 200
                .body(Commonresponse.success(
                        "All doctors fetched successfully",
                        doctorService.getAllDoctors()));
    }

    // =====================================================
    // GET DOCTOR BY ID
    // GET /api/doctors/{id}
    // SUCCESS → 200 OK
    // FAIL    → 404 Not Found
    // =====================================================
    @GetMapping("/{id}")
    public ResponseEntity<Commonresponse> getDoctorById(
            @PathVariable Long id) {

        return ResponseEntity
                .status(HttpStatus.OK)              // 200
                .body(Commonresponse.success(
                        "Doctor fetched successfully",
                        doctorService.getDoctorById(id)));
    }

    // =====================================================
    // GET DOCTORS BY SPECIALIZATION
    // GET /api/doctors/specialization?type=Cardiology
    // SUCCESS → 200 OK
    // FAIL    → 404 Not Found
    // =====================================================
    @GetMapping("/specialization")
    public ResponseEntity<Commonresponse>
    getDoctorsBySpecialization(
            @RequestParam String type) {

        return ResponseEntity
                .status(HttpStatus.OK)              // 200
                .body(Commonresponse.success(
                        "Doctors fetched for specialization: " + type,
                        doctorService.getDoctorsBySpecialization(type)));
    }

    // =====================================================
    // GET AVAILABLE DOCTORS
    // GET /api/doctors/available
    // SUCCESS → 200 OK
    // =====================================================
    @GetMapping("/available")
    public ResponseEntity<Commonresponse> getAvailableDoctors() {

        return ResponseEntity
                .status(HttpStatus.OK)              // 200
                .body(Commonresponse.success(
                        "Available doctors fetched successfully",
                        doctorService.getAvailableDoctors()));
    }

    // =====================================================
    // GET AVAILABLE DOCTORS BY SPECIALIZATION
    // GET /api/doctors/available/specialization?type=Neurology
    // SUCCESS → 200 OK
    // FAIL    → 404 Not Found
    // =====================================================
    @GetMapping("/available/specialization")
    public ResponseEntity<Commonresponse>
    getAvailableDoctorsBySpecialization(
            @RequestParam String type) {

        return ResponseEntity
                .status(HttpStatus.OK)              // 200
                .body(Commonresponse.success(
                        "Available doctors fetched for: " + type,
                        doctorService
                                .getAvailableDoctorsBySpecialization(
                                        type)));
    }

    // =====================================================
    // SEARCH DOCTORS BY NAME
    // GET /api/doctors/search?name=raj
    // SUCCESS → 200 OK
    // FAIL    → 404 Not Found
    // =====================================================
    @GetMapping("/search")
    public ResponseEntity<Commonresponse> searchDoctorsByName(
            @RequestParam String name) {

        return ResponseEntity
                .status(HttpStatus.OK)              // 200
                .body(Commonresponse.success(
                        "Doctors found with name: " + name,
                        doctorService.searchDoctorsByName(name)));
    }

    // =====================================================
    // FILTER DOCTORS
    // GET /api/doctors/filter
    // SUCCESS → 200 OK
    // =====================================================
    @GetMapping("/filter")
    public ResponseEntity<Commonresponse> filterDoctors(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String specialization,
            @RequestParam(required = false) Boolean available) {

        return ResponseEntity
                .status(HttpStatus.OK)              // 200
                .body(Commonresponse.success(
                        "Doctors filtered successfully",
                        doctorService.filterDoctors(
                                name, specialization, available)));
    }

    // =====================================================
    // GET ALL DOCTORS PAGINATED
    // GET /api/doctors/paginated?page=0&size=5&sortBy=name
    // SUCCESS → 200 OK
    // =====================================================
    @GetMapping("/paginated")
    public ResponseEntity<Commonresponse> getAllDoctorsPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy) {

        return ResponseEntity
                .status(HttpStatus.OK)              // 200
                .body(Commonresponse.success(
                        "Doctors fetched with pagination",
                        doctorService.getAllDoctorsPaginated(
                                page, size, sortBy)));
    }

    // =====================================================
    // GET AVAILABLE DOCTORS PAGINATED
    // GET /api/doctors/available/paginated?page=0&size=5
    // SUCCESS → 200 OK
    // =====================================================
    @GetMapping("/available/paginated")
    public ResponseEntity<Commonresponse>
    getAvailableDoctorsPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return ResponseEntity
                .status(HttpStatus.OK)              // 200
                .body(Commonresponse.success(
                        "Available doctors fetched with pagination",
                        doctorService.getAvailableDoctorsPaginated(
                                page, size)));
    }

    // =====================================================
    // GET DOCTORS BY SPECIALIZATION PAGINATED
    // GET /api/doctors/specialization/paginated
    // SUCCESS → 200 OK
    // =====================================================
    @GetMapping("/specialization/paginated")
    public ResponseEntity<Commonresponse>
    getDoctorsBySpecializationPaginated(
            @RequestParam String type,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return ResponseEntity
                .status(HttpStatus.OK)              // 200
                .body(Commonresponse.success(
                        "Doctors fetched by specialization paginated",
                        doctorService
                                .getDoctorsBySpecializationPaginated(
                                        type, page, size)));
    }

    // =====================================================
    // GET DOCTORS BY AVAILABLE DAY
    // GET /api/doctors/schedule?day=Monday
    // SUCCESS → 200 OK
    // FAIL    → 404 Not Found
    // =====================================================
    @GetMapping("/schedule")
    public ResponseEntity<Commonresponse>
    getDoctorsByAvailableDay(
            @RequestParam String day) {

        return ResponseEntity
                .status(HttpStatus.OK)              // 200
                .body(Commonresponse.success(
                        "Doctors available on: " + day,
                        doctorService
                                .getDoctorsByAvailableDay(day)));
    }

    // =====================================================
    // UPDATE DOCTOR
    // PUT /api/doctors/{id}
    // SUCCESS → 200 OK
    // FAIL    → 404 Not Found
    // FAIL    → 400 Bad Request (duplicate email)
    // =====================================================
    @PutMapping("/{id}")
    public ResponseEntity<Commonresponse> updateDoctor(
            @PathVariable Long id,
            @RequestBody Doctorrequest doctorrequest) {

        return ResponseEntity
                .status(HttpStatus.OK)              // 200
                .body(Commonresponse.success(
                        "Doctor updated successfully",
                        doctorService.updateDoctor(
                                id, doctorrequest)));
    }

    // =====================================================
    // UPDATE AVAILABILITY ONLY
    // PATCH /api/doctors/{id}/availability?status=false
    // SUCCESS → 200 OK
    // FAIL    → 404 Not Found
    // =====================================================
    @PatchMapping("/{id}/availability")
    public ResponseEntity<Commonresponse> updateAvailability(
            @PathVariable Long id,
            @RequestParam boolean status) {

        return ResponseEntity
                .status(HttpStatus.OK)              // 200
                .body(Commonresponse.success(
                        "Doctor availability updated to: " + status,
                        doctorService.updateAvailability(
                                id, status)));
    }

    // =====================================================
    // DELETE DOCTOR
    // DELETE /api/doctors/{id}
    // SUCCESS → 200 OK
    // FAIL    → 404 Not Found
    // =====================================================
    @DeleteMapping("/{id}")
    public ResponseEntity<Commonresponse> deleteDoctor(
            @PathVariable Long id) {

        doctorService.deleteDoctor(id);

        return ResponseEntity
                .status(HttpStatus.OK)              // 200
                .body(Commonresponse.success(
                        "Doctor deleted successfully with id: " + id,
                        null));
    }
}