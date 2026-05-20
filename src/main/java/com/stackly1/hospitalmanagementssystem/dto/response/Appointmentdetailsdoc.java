package com.stackly1.hospitalmanagementssystem.dto.response;

import java.time.LocalDate;

import lombok.Data;
//doctors to see their appointment details 
@Data
public class Appointmentdetailsdoc {
	private Integer appointment_id;
	private LocalDate appointment_date;
	private String name;

}
