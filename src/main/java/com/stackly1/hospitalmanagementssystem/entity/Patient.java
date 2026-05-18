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
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Patient")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Name")
	private String name;
	 
	@Column(name="Age")
	private int age;
	
	@Column(name="Gender")
	private String Gender;
	
	@Column(name="Phone_Number")
	private String ph_number;
	
	@OneToMany(mappedBy = "patient")
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<Appointment> appointments;

}
