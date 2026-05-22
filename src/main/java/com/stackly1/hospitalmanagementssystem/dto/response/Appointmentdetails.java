package com.stackly1.hospitalmanagementssystem.dto.response;

import java.time.LocalDate;

import lombok.Data;
//Patients to see their doctor appointment details
@Data
public class Appointmentdetails {
	private Integer appointment_id;
	private LocalDate appointment_date;
	private String appointment_status;
	

}


