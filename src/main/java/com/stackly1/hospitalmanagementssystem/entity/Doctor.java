package com.stackly1.hospitalmanagementssystem.entity;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "Name is required")
	@Column(nullable = false)
	private String name;

	@NotBlank(message = "Gender is required")
	@Column(nullable = false)
	private String gender;

	@NotBlank(message = "Email is required")
	@Email(message = "Email must be valid")
	@Column(nullable = false, unique = true)
	private String email;

	@NotBlank(message = "Specialization is required")
	@Column(nullable = false)
	private String specialization;

	@NotBlank(message = "Specialization is required")
	@Column(nullable = false)
	@Pattern(regexp = "^[0-9]\\d{9}$", message = "Invalid mobile number")
	private String ph_number;

	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonManagedReference
	private List<Appointment> appointments;

	public Doctor() {
	}

	public Doctor(String name, String gender, String email, String specialization, String ph_number,
			List<Appointment> appointments) {

		this.name = name;
		this.gender = gender;
		this.email = email;
		this.specialization = specialization;
		this.ph_number = ph_number;
		this.appointments = appointments;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getPh_number() {
		return ph_number;
	}

	public void setPh_number(String ph_number) {
		this.ph_number = ph_number;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

}
