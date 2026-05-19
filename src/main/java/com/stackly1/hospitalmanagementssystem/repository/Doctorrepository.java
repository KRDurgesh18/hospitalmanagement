package com.stackly1.hospitalmanagementssystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stackly1.hospitalmanagementssystem.entity.Doctor;

@Repository
public interface Doctorrepository extends JpaRepository<Doctor, Long> {

    // Basic finders
    Optional<Doctor> findByEmail(String email);
    Optional<Doctor> findByPhone(String phone);
    List<Doctor> findBySpecialization(String specialization);
    List<Doctor> findByAvailableTrue();
    List<Doctor> findByAvailableFalse();
    List<Doctor> findByNameContainingIgnoreCase(String name);
    List<Doctor> findBySpecializationAndAvailableTrue(String specialization);

    // Pagination
    Page<Doctor> findAll(Pageable pageable);
    Page<Doctor> findByAvailableTrue(Pageable pageable);
    Page<Doctor> findBySpecialization(String specialization, Pageable pageable);

    // Custom Query — filter by multiple fields
    @Query("SELECT d FROM Doctor d WHERE " +
           "(:name IS NULL OR LOWER(d.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND " +
           "(:specialization IS NULL OR d.specialization = :specialization) AND " +
           "(:available IS NULL OR d.available = :available)")
    List<Doctor> filterDoctors(
            @Param("name") String name,
            @Param("specialization") String specialization,
            @Param("available") Boolean available);

    // Custom Query — find by available days
    List<Doctor> findByAvailableDaysContainingIgnoreCase(String day);
}