package com.stackly1.hospitalmanagementssystem.service.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackly1.hospitalmanagementssystem.dto.request.Appointmentrequest;
import com.stackly1.hospitalmanagementssystem.dto.response.Appointmentresponse;
import com.stackly1.hospitalmanagementssystem.entity.Appointment;
import com.stackly1.hospitalmanagementssystem.entity.Doctor;
import com.stackly1.hospitalmanagementssystem.entity.Patient;
import com.stackly1.hospitalmanagementssystem.repository.Appointmentrepository;
import com.stackly1.hospitalmanagementssystem.repository.Doctorrepository;
import com.stackly1.hospitalmanagementssystem.repository.Patientrepository;
import com.stackly1.hospitalmanagementssystem.service.Appointmentservice;

@Service
public class AppointmentserviceImp implements Appointmentservice {

    @Autowired
    private Appointmentrepository appointmentRepository;

    @Autowired
    private Doctorrepository doctorRepository;

    @Autowired
    private Patientrepository patientRepository;

    // Save Appointment
    @Override
    public Appointmentresponse saveAppointment(
            Appointmentrequest request) {

        Doctor doctor = doctorRepository
                .findById(request.getDoctorId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Doctor Not Found"));

        Patient patient = patientRepository
                .findById(request.getPatientId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Patient Not Found"));

        Appointment appointment = new Appointment();

        appointment.setStatus("Booked");
        appointment.setAppointmentDate(
                request.getAppointmentDate());

        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

        Appointment savedAppointment =
                appointmentRepository.save(appointment);

        return mapToResponse(savedAppointment);
    }

    // Get All Appointments
    @Override
    public List<Appointmentresponse> getAllAppointments() {

        List<Appointment> appointments =
                appointmentRepository.findAll();

        List<Appointmentresponse> response =
                new ArrayList<>();

        for (Appointment appointment : appointments) {

            response.add(
                    mapToResponse(appointment));
        }

        return response;
    }

    // Get Appointment By ID
    @Override
    public Appointmentresponse getAppointmentById(
            Integer appointmentId) {

        Appointment appointment =
                appointmentRepository
                        .findById(appointmentId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Appointment Not Found"));

        return mapToResponse(appointment);
    }

    // Update Appointment
    @Override
    public Appointmentresponse updateAppointment(
            Integer appointmentId,
            Appointmentrequest request) {

        Appointment appointment =
                appointmentRepository
                        .findById(appointmentId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Appointment Not Found"));

        Doctor doctor = doctorRepository
                .findById(request.getDoctorId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Doctor Not Found"));

        Patient patient = patientRepository
                .findById(request.getPatientId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Patient Not Found"));

        appointment.setAppointmentDate(
                request.getAppointmentDate());

        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

        Appointment updatedAppointment =
                appointmentRepository.save(appointment);

        return mapToResponse(updatedAppointment);
    }

    // Delete Appointment
    @Override
    public String deleteAppointment(
            Integer appointmentId) {

        appointmentRepository.deleteById(
                appointmentId);

        return "Appointment Deleted Successfully";
    }

    // Convert Entity To Response
    private Appointmentresponse mapToResponse(
            Appointment appointment) {

        Appointmentresponse response =
                new Appointmentresponse();

        response.setId(appointment.getId());

        response.setStatus(
                appointment.getStatus());

        response.setAppointmentDate(
                appointment.getAppointmentDate());

        response.setDoctorId(
                appointment.getDoctor()
                        .getDoctorId());

        response.setPatientId(
                appointment.getPatient()
                        .getPatientId());

        return response;
    }
}