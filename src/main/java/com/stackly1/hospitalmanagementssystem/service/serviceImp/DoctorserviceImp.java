package com.stackly1.hospitalmanagementssystem.service.serviceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.stackly1.hospitalmanagementssystem.dto.response.Doctorresponse;
import com.stackly1.hospitalmanagementssystem.dto1.request.Doctorrequest;
import com.stackly1.hospitalmanagementssystem.entity.Appointment;
import com.stackly1.hospitalmanagementssystem.entity.Doctor;
import com.stackly1.hospitalmanagementssystem.exception.ResourceNotFoundException;
import com.stackly1.hospitalmanagementssystem.repository.Appointmentrepository;
import com.stackly1.hospitalmanagementssystem.repository.Doctorrepository;

@Service
public class DoctorserviceImp {

	private final Doctorrepository doctorRepository;

	public DoctorserviceImp(Doctorrepository doctorRepository) {
		this.doctorRepository = doctorRepository;
	}

	public Doctorresponse createUser(Doctorrequest dto) {
		if (doctorRepository.existsByEmail(dto.getEmail())) {
			throw new IllegalArgumentException("Email already exists: " + dto.getEmail());
		}
		Doctor doc = new Doctor(dto.getName(), dto.getGender(), dto.getEmail(), dto.getSpecialization(),
				dto.getPh_number(), dto.getAppointments());

		if (doc.getAppointments() != null) {

			for (Appointment appointment : doc.getAppointments()) {

				appointment.setDoctor(doc);
			}
		}

		Doctor saved = doctorRepository.save(doc);
		return toDTO(saved);
	}

	public List<Doctorresponse> getAllUsers() {
		return doctorRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
	}

	public Doctorresponse getUserById(Integer id) {
		Doctor doc = doctorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
		return toDTO(doc);
	}


	public Doctorresponse updateUser(Integer id, Doctorrequest dto) {

	    Doctor doc = doctorRepository.findById(id)
	            .orElseThrow(() ->
	                    new ResourceNotFoundException("User not found with id: " + id));

	    if (!doc.getEmail().equals(dto.getEmail())
	            && doctorRepository.existsByEmail(dto.getEmail())) {

	        throw new IllegalArgumentException(
	                "Email already exists: " + dto.getEmail());
	    }

	    doc.setName(dto.getName());
	    doc.setGender(dto.getGender());
	    doc.setEmail(dto.getEmail());
	    doc.setPh_number(dto.getPh_number());
	    doc.setSpecialization(dto.getSpecialization());

	    if (dto.getAppointments() != null) {
//	        doc.getAppointments().clear();
	        for (Appointment appointment : dto.getAppointments()) {
	            appointment.setDoctor(doc); 
	            doc.getAppointments().add(appointment);
	        }
	    }

	    Doctor updated = doctorRepository.save(doc);

	    return toDTO(updated);
	}

	public void deleteUser(Integer id) {
		if (!doctorRepository.existsById(id)) {
			throw new ResourceNotFoundException("User not found with id: " + id);
		}
		doctorRepository.deleteById(id);
	}

	public void deleteAppointment(Integer doctorId, Integer appointmentId) {

		Doctor doctor = doctorRepository.findById(doctorId)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor not found"));

		Appointment appointmentToRemove = doctor.getAppointments().stream()
				.filter(app -> app.getId().intValue() == appointmentId).findFirst()
				.orElseThrow(() -> new ResourceNotFoundException("Appointment not found"));

		doctor.getAppointments().remove(appointmentToRemove);

		doctorRepository.save(doctor);
	}

	private Doctorresponse toDTO(Doctor doc) {
		return new Doctorresponse(doc.getId(), doc.getName(), doc.getGender(), doc.getEmail(), doc.getSpecialization(),
				doc.getPh_number(), doc.getAppointments());
	}
}
