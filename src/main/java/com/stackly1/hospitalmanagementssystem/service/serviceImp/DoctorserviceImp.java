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
import com.stackly1.hospitalmanagementssystem.service.Doctrorservice;

@Service
public class DoctorserviceImp implements Doctrorservice {

	private final Doctorrepository doctorRepository;

	public DoctorserviceImp(Doctorrepository doctorRepository) {
		this.doctorRepository = doctorRepository;
	}

	public Doctorresponse createUser(Doctorrequest dto) {
		if (doctorRepository.existsByEmail(dto.getEmail())) {
			throw new IllegalArgumentException("Email already exists: " + dto.getEmail());
		}

		if (doctorRepository.findByPhnumber(dto.getPhnumber()).isPresent()) {
			throw new RuntimeException("Doctor already exists with phone: " + dto.getPhnumber());
		}

		Doctor doc = new Doctor(dto.getDoctorname(), dto.getGender(), dto.getEmail(), dto.getQualification(),
				dto.getSpecialization(), dto.getPhnumber(), dto.getAvailablestatus(), dto.getShifttype());
		Doctor saved = doctorRepository.save(doc);
		return toDTO(saved);
	}

	public List<Doctorresponse> getAllDoctors() {
		return doctorRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
	}

	public Doctorresponse getDoctorById(Integer id) {
		Doctor doc = doctorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id: " + id));
		return toDTO(doc);
	}

	public Doctorresponse getDoctorByName(String doctorname) {
		Doctor doc = doctorRepository.findByDoctorname(doctorname)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor not found with this Name : " + doctorname));
		return toDTO(doc);
	}

	public Doctorresponse getDoctorByMail(String email) {
		Doctor doc = doctorRepository.findByEmail(email)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor not found with this Email : " + email));
		return toDTO(doc);
	}

	@Override
	public Doctorresponse getDoctorByPhonenumber(String ph_number) {
		Doctor doc = doctorRepository.findByPhnumber(ph_number).orElseThrow(
				() -> new ResourceNotFoundException("Doctor not found with this phone number : " + ph_number));
		return toDTO(doc);
	}
	
	@Override
	public Doctorresponse getDoctorBySpecialitation(String specialization) {
		Doctor doc = doctorRepository.findBySpecialization(specialization).orElseThrow(
				() -> new ResourceNotFoundException("Doctor not found with this specialization : " + specialization));
		return toDTO(doc);
	}

	@Override
	public Doctorresponse getDoctorByAvaialblity(String availablestatus) {
		Doctor doc = doctorRepository.findByAvailablestatus(availablestatus).orElseThrow(
				() -> new ResourceNotFoundException("Doctor not found with this availablestatus : " + availablestatus));
		return toDTO(doc);
	}

	@Override
	public Doctorresponse getDoctorByShift(String shifttype) {
		Doctor doc = doctorRepository.findByShifttype(shifttype).orElseThrow(
				() -> new ResourceNotFoundException("Doctor not found with this shift type : " + shifttype));
		return toDTO(doc);
	}

	public Doctorresponse updateUser(Integer id, Doctorrequest dto) {

		Doctor doc = doctorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id: " + id));

		if (!doc.getEmail().equals(dto.getEmail()) && doctorRepository.existsByEmail(dto.getEmail())) {

			throw new IllegalArgumentException("Email already exists: " + dto.getEmail());
		}

		if (doctorRepository.findByPhnumber(doc.getPhnumber()).isPresent()) {
			throw new RuntimeException("Doctor already exists with phone: " + doc.getPhnumber());
		}
		
		doc.setDoctorname(dto.getDoctorname());
		doc.setGender(dto.getGender());
		doc.setEmail(dto.getEmail());
		doc.setPhnumber(dto.getPhnumber());
		doc.setSpecialization(dto.getSpecialization());
		doc.setQualification(dto.getQualification());
		doc.setShifttype(dto.getShifttype());
		doc.setAvailablestatus(dto.getAvailablestatus());

		Doctor updated = doctorRepository.save(doc);

		return toDTO(updated);

	}

	public void deleteUser(Integer id) {
		if (!doctorRepository.existsById(id)) {
			throw new ResourceNotFoundException("Doctor not found with id: " + id);
		}
		doctorRepository.deleteById(id);
	}

	private Doctorresponse toDTO(Doctor doc) {
		return new Doctorresponse(doc.getId(), doc.getDoctorname(), doc.getGender(), doc.getEmail(),
				doc.getQualification(), doc.getSpecialization(), doc.getPhnumber(), doc.getAvailablestatus(),
				doc.getShifttype());
	}

}
