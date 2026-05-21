package com.stackly1.hospitalmanagementssystem.service;

import java.util.*;

import com.stackly1.hospitalmanagementssystem.dto.response.Doctorresponse;
import com.stackly1.hospitalmanagementssystem.dto1.request.Doctorrequest;

public interface Doctrorservice {

	Doctorresponse createUser(Doctorrequest dto);

	List<Doctorresponse> getAllDoctors();

	Doctorresponse getDoctorById(Integer id);

	Doctorresponse getDoctorByMail(String email);
	
	Doctorresponse getDoctorByPhonenumber(String phnumber);
	
	Doctorresponse getDoctorBySpecialitation(String specialization);
	
	Doctorresponse getDoctorByAvaialblity(String availablestatus);
	
	Doctorresponse getDoctorByShift(String shifttype);

	Doctorresponse updateUser(Integer id, Doctorrequest dto);

	void deleteUser(Integer id);

}
