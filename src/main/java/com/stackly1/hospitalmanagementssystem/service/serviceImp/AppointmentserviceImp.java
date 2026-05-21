package com.stackly1.hospitalmanagementssystem.service.serviceImp;

import java.util.List;
import com.stackly1.hospitalmanagementssystem.dto.request.Appointmentrequest;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackly1.hospitalmanagementssystem.dto.response.Appointmentresponse;
import com.stackly1.hospitalmanagementssystem.entity.Appointment;
import com.stackly1.hospitalmanagementssystem.exception.ResourceNotFoundException;
import com.stackly1.hospitalmanagementssystem.repository.Appointmentrepository;
import com.stackly1.hospitalmanagementssystem.service.AppointmentService;
import com.stackly1.hospitalmanagementssystem.entity.Doctor;
import com.stackly1.hospitalmanagementssystem.entity.Patient;

@Service
public class AppointmentserviceImp implements AppointmentService {

    @Autowired
    private Appointmentrepository appointmentrepository;

    // helper method for entity -> dto mapping
    private Appointmentresponse mapToResponse(Appointment appointment) {
        Appointmentresponse response = new Appointmentresponse();

        response.setId(appointment.getId());
        response.setStatus(appointment.getStatus());
        response.setAppointment_date(appointment.getAppointment_date());
        response.setDoctor_id(appointment.getDoctor_id().getId());
        response.setPatient_id(appointment.getPatient_id().getId());

        return response;
    }

    @Override
    public List<Appointmentresponse> getAppointmentsByPatientId(int patientId) {
        List<Appointment> appointments =
                appointmentrepository.findByPatientId(patientId);

        if (appointments.isEmpty()) {
            throw new ResourceNotFoundException(
                    "No records found for Patient ID: " + patientId);
        }

        return appointments.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Appointmentresponse bookAppointment(Appointmentrequest  request) {

        Appointment appointment = new Appointment();

        appointment.setAppointment_date(request.getAppointment_date());

        // set default status
        appointment.setStatus("BOOKED");

        // map doctor
        Doctor doctor = new Doctor();
        doctor.setId(request.getDoctor_id());
        appointment.setDoctor_id(doctor);

        // map patient
        Patient patient = new Patient();
        patient.setId(request.getPatient_id());
        appointment.setPatient_id(patient);

        Appointment saved = appointmentrepository.save(appointment);

        return mapToResponse(saved);
    }

    @Override
    public Appointmentresponse cancelAppointment(int id) {
        Appointment appointment =
                appointmentrepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Appointment not found with ID: " + id));

        appointment.setStatus("CANCELLED");
        Appointment updated = appointmentrepository.save(appointment);

        return mapToResponse(updated);
    }

    @Override
    public List<Appointmentresponse> getAllAppointments() {
        return appointmentrepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<Appointmentresponse> getAppointmentsByDoctorId(int doctorId) {

        List<Appointment> appointments =
                appointmentrepository.findByDoctorId(doctorId);

        if (appointments.isEmpty()) {
            throw new ResourceNotFoundException(
                    "No records found for Doctor ID: " + doctorId);
        }

        return appointments.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
}