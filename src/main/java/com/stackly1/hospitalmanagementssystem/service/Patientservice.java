package com.stackly1.hospitalmanagementssystem.service;

import com.stackly1.hospitalmanagementssystem.common.Commonresponse;
import com.stackly1.hospitalmanagementssystem.dto.request.Patientrequest;
import com.stackly1.hospitalmanagementssystem.dto.response.Patientresponse;

public interface Patientservice {

	Commonresponse updatePatient(
            String uid,
            Patientrequest request);
}
