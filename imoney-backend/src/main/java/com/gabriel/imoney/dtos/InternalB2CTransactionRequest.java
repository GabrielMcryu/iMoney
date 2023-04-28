package com.gabriel.imoney.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InternalB2CTransactionRequest {

	@JsonProperty("Remarks")
	private String remarks;
	
	@JsonProperty("Amount")
	private String amount;
	
	@JsonProperty("Occassion")
	private String occassion;
	
	@JsonProperty("CommandID")
	private String commandID;
	
	@JsonProperty("PartyB")
	private String partyB;

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

	public String getPartyB() {
		return partyB;
	}

	public void setPartyB(String partyB) {
		this.partyB = partyB;
	}

	public InternalB2CTransactionRequest() {

	}

	public InternalB2CTransactionRequest(String remarks, String amount, String occassion, String commandID,
			String partyB) {
		this.remarks = remarks;
		this.amount = amount;
		this.occassion = occassion;
		this.commandID = commandID;
		this.partyB = partyB;
	}

	@Override
	public String toString() {
		return "InternalB2CTransactionRequest [remarks=" + remarks + ", amount=" + amount + ", occassion=" + occassion
				+ ", commandID=" + commandID + ", partyB=" + partyB + "]";
	}
	
	
}
