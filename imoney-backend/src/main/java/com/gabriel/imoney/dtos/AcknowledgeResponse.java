package com.gabriel.imoney.dtos;

import org.springframework.stereotype.Component;

@Component
public class AcknowledgeResponse {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public AcknowledgeResponse() {

	}

	public AcknowledgeResponse(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "AcknowledgeResponse [message=" + message + "]";
	}
	
	
}
