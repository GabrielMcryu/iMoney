package com.gabriel.imoney.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {

	@JsonProperty("ReferenceData")
	private ReferenceData referenceData;
	
	@JsonProperty("ConversationID")
	private String conversationID;
	
	@JsonProperty("OriginatorConversationID")
	private String originatorConversationID;
	
	@JsonProperty("ResultDesc")
	private String resultDesc;
	
	@JsonProperty("ResultType")
	private int resultType;
	
	@JsonProperty("ResultCode")
	private int resultCode;
	
	@JsonProperty("ResultParameters")
	private ResultParameters resultParameters;
	
	@JsonProperty("TransactionID")
	private String transactionID;

	public ReferenceData getReferenceData() {
		return referenceData;
	}

	public void setReferenceData(ReferenceData referenceData) {
		this.referenceData = referenceData;
	}

	public String getConversationID() {
		return conversationID;
	}

	public void setConversationID(String conversationID) {
		this.conversationID = conversationID;
	}

	public String getOriginatorConversationID() {
		return originatorConversationID;
	}

	public void setOriginatorConversationID(String originatorConversationID) {
		this.originatorConversationID = originatorConversationID;
	}

	public String getResultDesc() {
		return resultDesc;
	}

	public void setResultDesc(String resultDesc) {
		this.resultDesc = resultDesc;
	}

	public int getResultType() {
		return resultType;
	}

	public void setResultType(int resultType) {
		this.resultType = resultType;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public ResultParameters getResultParameters() {
		return resultParameters;
	}

	public void setResultParameters(ResultParameters resultParameters) {
		this.resultParameters = resultParameters;
	}

	public String getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}

	public Result() {

	}

	public Result(ReferenceData referenceData, String conversationID, String originatorConversationID,
			String resultDesc, int resultType, int resultCode, ResultParameters resultParameters,
			String transactionID) {
		this.referenceData = referenceData;
		this.conversationID = conversationID;
		this.originatorConversationID = originatorConversationID;
		this.resultDesc = resultDesc;
		this.resultType = resultType;
		this.resultCode = resultCode;
		this.resultParameters = resultParameters;
		this.transactionID = transactionID;
	}

	@Override
	public String toString() {
		return "Result [referenceData=" + referenceData + ", conversationID=" + conversationID
				+ ", originatorConversationID=" + originatorConversationID + ", resultDesc=" + resultDesc
				+ ", resultType=" + resultType + ", resultCode=" + resultCode + ", resultParameters=" + resultParameters
				+ ", transactionID=" + transactionID + "]";
	}

	
}
