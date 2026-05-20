package com.stackly1.hospitalmanagementssystem.dto.response;

import lombok.Data;

@Data
public class Patientresponse {

    private Integer id;

    private String uid;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private Integer age;

    private String gender;

    private String bloodGroup;

    private String address;

    private String emergencyContact;

    private String status;
}