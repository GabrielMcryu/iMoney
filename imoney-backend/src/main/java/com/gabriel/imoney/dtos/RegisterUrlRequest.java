package com.gabriel.imoney.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterUrlRequest {

	@JsonProperty("ShortCode")
	private String shortCode;
	
	@JsonProperty("ConfirmationURL")
	private String confirmationURL;
	
	@JsonProperty("ValidationURL")
	private String validationURL;
	
	@JsonProperty("ResponseType")
	private String responseType;

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public String getConfirmationURL() {
		return confirmationURL;
	}

	public void setConfirmationURL(String confirmationURL) {
		this.confirmationURL = confirmationURL;
	}

	public String getValidationURL() {
		return validationURL;
	}

	public void setValidationURL(String validationURL) {
		this.validationURL = validationURL;
	}

	public String getResponseType() {
		return responseType;
	}

	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}

	public RegisterUrlRequest() {

	}

	public RegisterUrlRequest(String shortCode, String confirmationURL, String validationURL, String responseType) {
		this.shortCode = shortCode;
		this.confirmationURL = confirmationURL;
		this.validationURL = validationURL;
		this.responseType = responseType;
	}

	@Override
	public String toString() {
		return "RegisterUrlRequest [shortCode=" + shortCode + ", confirmationURL=" + confirmationURL
				+ ", validationURL=" + validationURL + ", responseType=" + responseType + "]";
	}
	
	
}
