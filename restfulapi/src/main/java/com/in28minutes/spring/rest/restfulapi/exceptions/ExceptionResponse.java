package com.in28minutes.spring.rest.restfulapi.exceptions;

import java.util.Date;

public class ExceptionResponse {

	private Date timestamp;
	private String message;
	private String detatils;

	public ExceptionResponse(Date timestamp, String message, String detatils) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.detatils = detatils;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetatils() {
		return detatils;
	}

}
