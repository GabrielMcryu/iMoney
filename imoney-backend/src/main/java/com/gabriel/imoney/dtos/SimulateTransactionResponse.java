package com.gabriel.imoney.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SimulateTransactionResponse {

	@JsonProperty("ResponseDescription")
	private String responseDescription;
	
	@JsonProperty("ResponseCode")
	private String responseCode;
	
	@JsonProperty("OriginatorCoversationID")
	private String originatorCoversationID;

	public String getResponseDescription() {
		return responseDescription;
	}

	public void setResponseDescription(String responseDescription) {
		this.responseDescription = responseDescription;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getOriginatorCoversationID() {
		return originatorCoversationID;
	}

	public void setOriginatorCoversationID(String originatorCoversationID) {
		this.originatorCoversationID = originatorCoversationID;
	}

	public SimulateTransactionResponse() {
		
	}

	public SimulateTransactionResponse(String responseDescription, String responseCode,
			String originatorCoversationID) {
		this.responseDescription = responseDescription;
		this.responseCode = responseCode;
		this.originatorCoversationID = originatorCoversationID;
	}

	@Override
	public String toString() {
		return "SimulateTransactionResponse [responseDescription=" + responseDescription + ", responseCode="
				+ responseCode + ", originatorCoversationID=" + originatorCoversationID + "]";
	}
	
	
}
