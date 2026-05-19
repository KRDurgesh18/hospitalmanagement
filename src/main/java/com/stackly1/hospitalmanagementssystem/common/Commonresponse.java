package com.stackly1.hospitalmanagementssystem.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Commonresponse<T> {

    private boolean success;
    private String message;
    private T data;
	public static Object builder() {
		// TODO Auto-generated method stub
		return null;
	}
	
}