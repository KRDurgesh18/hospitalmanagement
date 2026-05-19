package com.stackly1.hospitalmanagementssystem.dto.response;

import lombok.Data;

@Data
public class Patientresponse {

	private String name;
	private String age;
	private Integer patient_id;
	private String gender;
	private String ph_number;
}
