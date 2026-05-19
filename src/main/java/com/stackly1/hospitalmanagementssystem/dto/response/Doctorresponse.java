package com.stackly1.hospitalmanagementssystem.dto.response;

import java.util.List;

import com.stackly1.hospitalmanagementssystem.entity.Appointment;

import lombok.Data;

@Data
public class Doctorresponse {

	private Integer id;
	private String name;
	private String gender;
	private String email;
	private String specialization;
	private String ph_number;
	private List<Appointment> appointments;

	public Doctorresponse(Integer id, String name, String gender, String email, String specialization,
			String ph_number,
			List<Appointment> appointments) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.specialization = specialization;
		this.ph_number = ph_number;
		this.setAppointments(appointments);

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
