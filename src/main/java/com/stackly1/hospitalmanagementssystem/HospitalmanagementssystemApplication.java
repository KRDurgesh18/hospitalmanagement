package com.stackly1.hospitalmanagementssystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.stackly1.hospitalmanagementssystem.entity")
@EnableJpaRepositories("com.stackly1.hospitalmanagementssystem.repository")
@ComponentScan("com.stackly1.hospitalmanagementssystem")
public class HospitalmanagementssystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalmanagementssystemApplication.class, args);
	}

}
