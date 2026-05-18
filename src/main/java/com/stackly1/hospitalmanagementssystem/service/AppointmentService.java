package com.stackly1.hospitalmanagementssystem.service;

import com.stackly1.hospitalmanagementssystem.dto.AppointmentDTO;
import java.util.List;

public interface AppointmentService {
    List<AppointmentDTO> getAppointmentsByDoctor(int doctorId);
}