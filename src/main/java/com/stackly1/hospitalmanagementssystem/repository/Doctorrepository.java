package com.stackly1.hospitalmanagementssystem.repository;

import com.stackly1.hospitalmanagementssystem.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//JpaRepository gives us save(), findAll(), findById(), deleteById()
//automatically — no need to write SQL!
public interface Doctorrepository extends JpaRepository<Doctor, Long> {

}