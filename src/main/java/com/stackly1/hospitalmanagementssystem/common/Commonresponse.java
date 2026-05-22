package com.stackly1.hospitalmanagementssystem.common;

import lombok.Data;

@Data
public class Commonresponse<T> {
	private boolean success;
	private String message;
	private T data;

	public void ApiResponse() {
	}

	public Commonresponse(boolean success, String message, T data) {
		this.success = success;
		this.message = message;
		this.data = data;
	}

}
