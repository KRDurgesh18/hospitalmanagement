package com.stackly1.hospitalmanagementssystem.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "patients")
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

	    private int age;

	    private String gender;

	    private String bloodGroup;

	    private String address;

	    private String emergencyContact;

	    private String status;

	    private LocalDateTime createdAt;

	    private LocalDateTime updatedAt;


}
