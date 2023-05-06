package com.gabriel.imoney.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class C2BTransaction {

	private String senderName;
	
	private String merchant;
	
	private String shortCode;
	
	private String msisdn;
	
	private String billRefNumber;
	
	private String amount;
	
	private String commandID;
	
	private String responseDescription;
	
	private String responseCode;
	
	private String originatorCoversationID;

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getMerchant() {
		return merchant;
	}

	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}

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

	public C2BTransaction() {

	}

	public C2BTransaction(String senderName, String merchant, String shortCode, String msisdn, String billRefNumber,
			String amount, String commandID, String responseDescription, String responseCode,
			String originatorCoversationID) {
		this.senderName = senderName;
		this.merchant = merchant;
		this.shortCode = shortCode;
		this.msisdn = msisdn;
		this.billRefNumber = billRefNumber;
		this.amount = amount;
		this.commandID = commandID;
		this.responseDescription = responseDescription;
		this.responseCode = responseCode;
		this.originatorCoversationID = originatorCoversationID;
	}

	@Override
	public String toString() {
		return "C2BTransaction [senderName=" + senderName + ", merchant=" + merchant + ", shortCode=" + shortCode
				+ ", msisdn=" + msisdn + ", billRefNumber=" + billRefNumber + ", amount=" + amount + ", commandID="
				+ commandID + ", responseDescription=" + responseDescription + ", responseCode=" + responseCode
				+ ", originatorCoversationID=" + originatorCoversationID + "]";
	}
	
	
}
