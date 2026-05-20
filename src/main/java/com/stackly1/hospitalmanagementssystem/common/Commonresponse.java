package com.stackly1.hospitalmanagementssystem.common;

import lombok.Data;

@Data
public class Commonresponse {

    private String statuscode;

    private String message;

    private Object data;
}
