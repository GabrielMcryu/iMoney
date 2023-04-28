package com.gabriel.imoney.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterUrlResponse {

	@JsonProperty("ResponseCode")
	private String responseCode;
	
	@JsonProperty("ResponseDescription")
	private String responseDescription;
	
	@JsonProperty("OriginatorConversationID")
	private String originatorConversationID;

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseDescription() {
		return responseDescription;
	}

	public void setResponseDescription(String responseDescription) {
		this.responseDescription = responseDescription;
	}

	public String getOriginatorConversationID() {
		return originatorConversationID;
	}

	public void setOriginatorConversationID(String originatorConversationID) {
		this.originatorConversationID = originatorConversationID;
	}

	public RegisterUrlResponse() {

	}

	public RegisterUrlResponse(String responseCode, String responseDescription, String originatorConversationID) {
		this.responseCode = responseCode;
		this.responseDescription = responseDescription;
		this.originatorConversationID = originatorConversationID;
	}

	@Override
	public String toString() {
		return "RegisterUrlResponse [responseCode=" + responseCode + ", responseDescription=" + responseDescription
				+ ", originatorConversationID=" + originatorConversationID + "]";
	}
	
	
	
}
