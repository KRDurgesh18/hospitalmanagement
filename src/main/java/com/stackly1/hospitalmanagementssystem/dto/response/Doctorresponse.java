package com.stackly1.hospitalmanagementssystem.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctorresponse {

    private Long id;
    private String name;
    private String specialization;
    private String email;
    private String phone;
    private String qualification;
    private boolean available;

    // Schedule fields
    private String startTime;
    private String endTime;
    private String availableDays;
}