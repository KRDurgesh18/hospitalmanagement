package com.stackly1.hospitalmanagementssystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackly1.hospitalmanagementssystem.entity.Appointment;
import com.stackly1.hospitalmanagementssystem.exception.ResourceNotFoundException;
import com.stackly1.hospitalmanagementssystem.repository.Appointmentrepository;

@Service
public class AppointmentService {

    @Autowired
    private Appointmentrepository appointmentrepository;

    // get appointment by patient id
    public List<Appointment> getAppointmentsByPatientId(int patientId){

        List<Appointment> appointments =
                appointmentrepository.findByPatientId(patientId);

        if(appointments.isEmpty()) {
            throw new ResourceNotFoundException(
                    "No appointments found for patient id: " + patientId);
        }

        return appointments;
    }


    // book appointment
    public Appointment bookAppointment(Appointment appointment){
        return appointmentrepository.save(appointment);
    }


    // cancel appointment
    public Appointment cancelAppointment(int id){

        Appointment appointment =
                appointmentrepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                            "Appointment not found with id: " + id));

        appointment.setStatus("CANCELLED");

        return appointmentrepository.save(appointment);
    }


    // get all appointments
    public List<Appointment> getAllAppointments(){

        List<Appointment> appointments =
                appointmentrepository.findAll();

        if(appointments.isEmpty()) {
            throw new ResourceNotFoundException(
                    "No appointments found");
        }

        return appointments;
    }


    // get doctor appointments
    public List<Appointment> getAppointmentsByDoctorId(int doctorId){

        List<Appointment> appointments =
                appointmentrepository.findByDoctorId(doctorId);

        if(appointments.isEmpty()) {
            throw new ResourceNotFoundException(
                    "No appointments found for doctor id: " + doctorId);
        }

        return appointments;
    }
}