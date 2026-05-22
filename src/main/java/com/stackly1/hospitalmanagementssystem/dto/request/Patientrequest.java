package com.stackly1.hospitalmanagementssystem.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Patientrequest {
	@NotBlank(message = "First name is required")
    private String firstName;
 
    private String lastName;
 
    @Email(message = "Enter valid email")
    @NotBlank(message = "Email is required")
    private String email;
 
    @NotBlank(message = "Phone number is required")
    private String phoneNumber;
 
    @NotBlank(message = "Password is required")
    private String password;
 
    @NotNull(message = "Age is required")
    @Min(value = 1, message = "Age must be greater than 0")
    private Integer age;
 
    @NotBlank(message = "Gender is required")
    private String gender;
 
    private String bloodGroup;
 
    private String address;
 
    private String emergencyContact;

}
