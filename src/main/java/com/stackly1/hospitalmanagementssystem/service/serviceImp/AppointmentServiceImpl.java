package com.stackly1.hospitalmanagementssystem.service.serviceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackly1.hospitalmanagementssystem.dto.AppointmentDTO;
import com.stackly1.hospitalmanagementssystem.entity.Appointment;
import com.stackly1.hospitalmanagementssystem.entity.Doctor;  
import com.stackly1.hospitalmanagementssystem.entity.Patient; 
import com.stackly1.hospitalmanagementssystem.exception.ResourceNotFoundException;
import com.stackly1.hospitalmanagementssystem.repository.AppointmentRepository;
import com.stackly1.hospitalmanagementssystem.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public List<AppointmentDTO> getAppointmentsByDoctor(int doctorId) {
        List<Appointment> appointments = appointmentRepository.findByDoctorId(doctorId);
        
        if (appointments.isEmpty()) {
            throw new ResourceNotFoundException("No appointments found for Doctor ID: " + doctorId);
        }

        return appointments.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    private AppointmentDTO mapToDTO(Appointment appointment) {
        AppointmentDTO dto = new AppointmentDTO();
        
        dto.setId(appointment.getId());
        dto.setStatus(appointment.getStatus());
        dto.setAppointmentDate(appointment.getAppointmentDate());

        if (appointment.getDoctor() != null) {
            Doctor doc = appointment.getDoctor();
            dto.setDoctorId(doc.getId());
            dto.setDoctorName(doc.getName());
        }

        if (appointment.getPatient() != null) {
            Patient pat = appointment.getPatient();
            dto.setPatientId(pat.getId());
            dto.setPatientName(pat.getName());
        }

        return dto;
    }
}