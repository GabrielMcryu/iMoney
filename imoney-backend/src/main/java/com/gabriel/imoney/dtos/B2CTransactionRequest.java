package com.gabriel.imoney.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class B2CTransactionRequest {

	@JsonProperty("QueueTimeOutURL")
	private String queueTimeOutURL;
	
	@JsonProperty("Remarks")
	private String remarks;
	
	@JsonProperty("Amount")
	private String amount;
	
	@JsonProperty("InitiatorName")
	private String initiatorName;
	
	@JsonProperty("SecurityCredential")
	private String securityCredential;
	
	@JsonProperty("Occassion")
	private String occassion;
	
	@JsonProperty("CommandID")
	private String commandID;
	
	@JsonProperty("PartyA")
	private String partyA;
	
	@JsonProperty("PartyB")
	private String partyB;
	
	@JsonProperty("ResultURL")
	private String resultURL;

	public String getQueueTimeOutURL() {
		return queueTimeOutURL;
	}

	public void setQueueTimeOutURL(String queueTimeOutURL) {
		this.queueTimeOutURL = queueTimeOutURL;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getInitiatorName() {
		return initiatorName;
	}

	public void setInitiatorName(String initiatorName) {
		this.initiatorName = initiatorName;
	}

	public String getSecurityCredential() {
		return securityCredential;
	}

	public void setSecurityCredential(String securityCredential) {
		this.securityCredential = securityCredential;
	}

	public String getOccassion() {
		return occassion;
	}

	public void setOccassion(String occassion) {
		this.occassion = occassion;
	}

	public String getCommandID() {
		return commandID;
	}

	public void setCommandID(String commandID) {
		this.commandID = commandID;
	}

	public String getPartyA() {
		return partyA;
	}

	public void setPartyA(String partyA) {
		this.partyA = partyA;
	}

	public String getPartyB() {
		return partyB;
	}

	public void setPartyB(String partyB) {
		this.partyB = partyB;
	}

	public String getResultURL() {
		return resultURL;
	}

	public void setResultURL(String resultURL) {
		this.resultURL = resultURL;
	}

	public B2CTransactionRequest() {

	}

	public B2CTransactionRequest(String queueTimeOutURL, String remarks, String amount, String initiatorName,
			String securityCredential, String occassion, String commandID, String partyA, String partyB,
			String resultURL) {
		this.queueTimeOutURL = queueTimeOutURL;
		this.remarks = remarks;
		this.amount = amount;
		this.initiatorName = initiatorName;
		this.securityCredential = securityCredential;
		this.occassion = occassion;
		this.commandID = commandID;
		this.partyA = partyA;
		this.partyB = partyB;
		this.resultURL = resultURL;
	}

	@Override
	public String toString() {
		return "B2CTransactionRequest [queueTimeOutURL=" + queueTimeOutURL + ", remarks=" + remarks + ", amount="
				+ amount + ", initiatorName=" + initiatorName + ", securityCredential=" + securityCredential
				+ ", occassion=" + occassion + ", commandID=" + commandID + ", partyA=" + partyA + ", partyB=" + partyB
				+ ", resultURL=" + resultURL + "]";
	}
	
	
}
