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

	@NotBlank(message = "Doctor Name is required")
	@Column(nullable = false)
	private String doctorname;

	@NotBlank(message = "Gender is required")
	@Column(nullable = false)
	private String gender;

	@NotBlank(message = "Email is required")
	@Email(message = "Email must be valid")
	@Column(nullable = false, unique = true)
	private String email;

	@NotBlank(message = "Qualification is required")
	@Column(nullable = false)
	private String qualification;

	@NotBlank(message = "Specialization is required")
	@Column(nullable = false)
	private String specialization;

	@NotBlank(message = "Phone Number is required")
	@Column(nullable = false)
	@Pattern(regexp = "^[0-9]\\d{9}$", message = "Invalid mobile number")
	private String phnumber;

	@NotBlank(message = "Availablity Status is required")
	@Column(nullable = false)
	private String availablestatus;

	@NotBlank(message = "Shift Type is required")
	@Column(nullable = false)
	private String shifttype;

//	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL,orphanRemoval = true)
//	@JsonManagedReference
//	private List<Appointment> appointments;

	public Doctor() {
	}

	public Doctor(String doctorname, String gender, String email, String qualification, String specialization,
			String phnumber, String availablestatus, String shifttype) {

		this.doctorname = doctorname;
		this.gender = gender;
		this.email = email;
		this.qualification = qualification;
		this.specialization = specialization;
		this.phnumber = phnumber;
		this.availablestatus = availablestatus;
		this.shifttype = shifttype;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDoctorname() {
		return doctorname;
	}

	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getPhnumber() {
		return phnumber;
	}

	public void setPhnumber(String phnumber) {
		this.phnumber = phnumber;
	}

	public String getAvailablestatus() {
		return availablestatus;
	}

	public void setAvailablestatus(String availablestatus) {
		this.availablestatus = availablestatus;
	}

	public String getShifttype() {
		return shifttype;
	}

	public void setShifttype(String shifttype) {
		this.shifttype = shifttype;
	}

}
