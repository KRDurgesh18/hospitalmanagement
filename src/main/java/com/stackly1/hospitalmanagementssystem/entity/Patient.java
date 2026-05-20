package com.stackly1.hospitalmanagementssystem.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String uid;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
    private String password;
    private Integer age;
    private String gender; 
    private String bloodGroup;
    private String address;
    private String emergencyContact;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;
    
	
}
