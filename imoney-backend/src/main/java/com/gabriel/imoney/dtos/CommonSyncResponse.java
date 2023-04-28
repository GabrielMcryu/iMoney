package com.gabriel.imoney.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommonSyncResponse {

	@JsonProperty("ConversationID")
	private String conversationID;
	
	@JsonProperty("ResponseCode")
	private String responseCode;
	
	@JsonProperty("OriginatorConversationID")
	private String originatorConversationID;
	
	@JsonProperty("ResponseDescription")
	private String responseDescription;

	public String getConversationID() {
		return conversationID;
	}

	public void setConversationID(String conversationID) {
		this.conversationID = conversationID;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getOriginatorConversationID() {
		return originatorConversationID;
	}

	public void setOriginatorConversationID(String originatorConversationID) {
		this.originatorConversationID = originatorConversationID;
	}

	public String getResponseDescription() {
		return responseDescription;
	}

	public void setResponseDescription(String responseDescription) {
		this.responseDescription = responseDescription;
	}

	public CommonSyncResponse() {

	}

	public CommonSyncResponse(String conversationID, String responseCode, String originatorConversationID,
			String responseDescription) {
		this.conversationID = conversationID;
		this.responseCode = responseCode;
		this.originatorConversationID = originatorConversationID;
		this.responseDescription = responseDescription;
	}

	@Override
	public String toString() {
		return "CommonSyncResponse [conversationID=" + conversationID + ", responseCode=" + responseCode
				+ ", originatorConversationID=" + originatorConversationID + ", responseDescription="
				+ responseDescription + "]";
	}
	
	
}
