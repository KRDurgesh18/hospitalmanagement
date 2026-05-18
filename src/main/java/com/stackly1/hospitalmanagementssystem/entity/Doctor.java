package com.stackly1.hospitalmanagementssystem.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    
    @Column(name="Name")
	private String name;
    
    @Column(name="Specialization")
	private String specialization;
    
    @Column(name="Phone_Number")
	private String ph_number;
	
	@OneToMany(mappedBy = "doctor")
	@ToString.Exclude // Prevents infinite loops
	@EqualsAndHashCode.Exclude // Prevents infinite loops
	private List<Appointment> appointments;
	
}

