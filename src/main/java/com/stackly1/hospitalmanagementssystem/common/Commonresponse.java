package com.stackly1.hospitalmanagementssystem.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Commonresponse<T> {

	Integer statuscode;
	String message;
	Object data;

	public Commonresponse(Integer statuscode, String message, Object data) {

		this.statuscode = statuscode;
		this.message = message;
		this.data = data;
	}

	public Integer getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(Integer statuscode) {
		this.statuscode = statuscode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
