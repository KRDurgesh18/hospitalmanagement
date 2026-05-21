package com.stackly1.hospitalmanagementssystem.dto.response;

import java.util.List;

import com.stackly1.hospitalmanagementssystem.entity.Appointment;

import lombok.Data;

@Data
public class Doctorresponse {

	private Integer id;
	private String doctorname;
	private String gender;
	private String email;
	private String qualification;
	private String specialization;
	private String phnumber;
	private String availablestatus;
	private String shifttype;

//	private List<Appointment> appointments;

	public Doctorresponse(Integer id, String doctorname, String gender, String email, String qualification,
			String specialization, String phnumber, String availablestatus, String shifttype) {
		this.id = id;
		this.doctorname = doctorname;
		this.gender = gender;
		this.email = email;
		this.qualification = qualification;
		this.specialization = specialization;
		this.phnumber = phnumber;
		this.availablestatus = availablestatus;
		this.shifttype = shifttype;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
