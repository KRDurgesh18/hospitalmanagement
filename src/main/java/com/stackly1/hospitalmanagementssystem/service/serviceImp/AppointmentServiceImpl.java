package com.stackly1.hospitalmanagementssystem.service.serviceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackly1.hospitalmanagementssystem.dto.request.Appointmentrequest;
import com.stackly1.hospitalmanagementssystem.dto.response.AppointmentResponseDto;
import com.stackly1.hospitalmanagementssystem.entity.Appointment;
import com.stackly1.hospitalmanagementssystem.repository.AppointmentRepository;
import com.stackly1.hospitalmanagementssystem.repository.Doctorrepository;
import com.stackly1.hospitalmanagementssystem.repository.Patientrepository;
import com.stackly1.hospitalmanagementssystem.service.Appointmentservice;

@Service
public class AppointmentServiceImpl implements Appointmentservice {

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private Patientrepository patientRepository; // Injected to verify patient exists

    @Autowired
    private Doctorrepository doctorRepository; // Injected to verify doctor exists

    @Override
    public AppointmentResponseDto bookAppointment(Appointmentrequest requestDto) {
    	
    	boolean patientExists = patientRepository.existsById(requestDto.getPatientId());
        if (!patientExists) {
            throw new RuntimeException("Cannot book appointment. Patient not found with ID: " + requestDto.getPatientId());
        }

        // 2. Verify Doctor exists in the database
        boolean doctorExists = doctorRepository.existsById(requestDto.getDoctorId());
        if (!doctorExists) {
            throw new RuntimeException("Cannot book appointment. Doctor not found with ID: " + requestDto.getDoctorId());
        }
        Appointment appointment = new Appointment();
        appointment.setPatientId(requestDto.getPatientId());
        appointment.setDoctorId(requestDto.getDoctorId());
        appointment.setAppointmentDate(requestDto.getAppointmentDate());
        appointment.setReason(requestDto.getReason());
        appointment.setStatus("BOOKED");

        Appointment savedAppointment = appointmentRepository.save(appointment);
        return mapToResponseDto(savedAppointment);
    }

    @Override
    public AppointmentResponseDto cancelAppointment(Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with ID: " + id)); // You can map this to a custom Exception later
        
        appointment.setStatus("CANCELLED");
        Appointment updatedAppointment = appointmentRepository.save(appointment);
        return mapToResponseDto(updatedAppointment);
    }

    @Override
    public List<AppointmentResponseDto> getAllAppointments() {
        return appointmentRepository.findAll().stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentResponseDto> getDoctorAppointments(Long doctorId) {
        List<Appointment> appointments = appointmentRepository.findByDoctorId(doctorId);
        
        // Check if the list is empty, and explicitly throw an exception
        if (appointments.isEmpty()) {
            throw new RuntimeException("No appointments found for Doctor ID: " + doctorId);
        }
        
        return appointments.stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentResponseDto> getPatientAppointments(Long patientId) {
        List<Appointment> appointments = appointmentRepository.findByPatientId(patientId);
        
        // Check if the patient has any appointments, if not, throw an exception
        if (appointments.isEmpty()) {
            throw new RuntimeException("No appointments found for Patient ID: " + patientId);
        }
        
        return appointments.stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }
    // Utility method to map Entity to Response DTO
    private AppointmentResponseDto mapToResponseDto(Appointment appointment) {
        AppointmentResponseDto dto = new AppointmentResponseDto();
        dto.setId(appointment.getId());
        dto.setPatientId(appointment.getPatientId());
        dto.setDoctorId(appointment.getDoctorId());
        dto.setAppointmentDate(appointment.getAppointmentDate());
        dto.setStatus(appointment.getStatus());
        dto.setReason(appointment.getReason());
        return dto;
    }
}