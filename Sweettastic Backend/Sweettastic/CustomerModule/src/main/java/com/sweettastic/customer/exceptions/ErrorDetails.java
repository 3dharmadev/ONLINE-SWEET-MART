package com.sweettastic.customer.exceptions;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class ErrorDetails {
	
	private LocalDateTime timestamp;
	private String message;
	private String description;
	
	
	public ErrorDetails() {
		// TODO Auto-generated constructor stub
	}


	public ErrorDetails(LocalDateTime timestamp, String message, String description) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.description = description;
	}


	public LocalDateTime getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "MyExceptions [timestamp=" + timestamp + ", message=" + message + ", description=" + description + "]";
	}

}
