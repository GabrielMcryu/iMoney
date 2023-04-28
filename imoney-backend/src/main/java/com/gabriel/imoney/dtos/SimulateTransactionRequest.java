package com.gabriel.imoney.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SimulateTransactionRequest {

	@JsonProperty("ShortCode")
	private String shortCode;
	
	@JsonProperty("Msisdn")
	private String msisdn;
	
	@JsonProperty("BillRefNumber")
	private String billRefNumber;
	
	@JsonProperty("Amount")
	private String amount;
	
	@JsonProperty("CommandID")
	private String commandID;

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getBillRefNumber() {
		return billRefNumber;
	}

	public void setBillRefNumber(String billRefNumber) {
		this.billRefNumber = billRefNumber;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCommandID() {
		return commandID;
	}

	public void setCommandID(String commandID) {
		this.commandID = commandID;
	}

	public SimulateTransactionRequest() {

	}

	public SimulateTransactionRequest(String shortCode, String msisdn, String billRefNumber, String amount,
			String commandID) {
		this.shortCode = shortCode;
		this.msisdn = msisdn;
		this.billRefNumber = billRefNumber;
		this.amount = amount;
		this.commandID = commandID;
	}

	@Override
	public String toString() {
		return "SimulateTransactionRequest [shortCode=" + shortCode + ", msisdn=" + msisdn + ", billRefNumber="
				+ billRefNumber + ", amount=" + amount + ", commandID=" + commandID + "]";
	}
	
	
}
