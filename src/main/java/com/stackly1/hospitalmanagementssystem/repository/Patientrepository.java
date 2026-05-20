package com.stackly1.hospitalmanagementssystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import com.stackly1.hospitalmanagementssystem.entity.Patient;

@Repository
public interface Patientrepository extends JpaRepository<Patient, Integer> {
	

	Optional<Patient> findByUid(String uid);

}
