package com.gabriel.imoney.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class C2BData {

	@JsonProperty("SenderName")
	private String senderName;
	
	@JsonProperty("Merchant")
	private String merchant;
	
	@JsonProperty("ReceiverAccountNumber")
	private Long receiverAccountNumber;
	
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

	public Long getReceiverAccountNumber() {
		return receiverAccountNumber;
	}

	public void setReceiverAccountNumber(Long receiverAccountNumber) {
		this.receiverAccountNumber = receiverAccountNumber;
	}

	public C2BData() {

	}

	public C2BData(String senderName, String merchant, Long receiverAccountNumber, String shortCode, String msisdn,
			String billRefNumber, String amount, String commandID) {
		this.senderName = senderName;
		this.merchant = merchant;
		this.receiverAccountNumber = receiverAccountNumber;
		this.shortCode = shortCode;
		this.msisdn = msisdn;
		this.billRefNumber = billRefNumber;
		this.amount = amount;
		this.commandID = commandID;
	}

	@Override
	public String toString() {
		return "C2BData [senderName=" + senderName + ", merchant=" + merchant + ", receiverAccountNumber="
				+ receiverAccountNumber + ", shortCode=" + shortCode + ", msisdn=" + msisdn + ", billRefNumber="
				+ billRefNumber + ", amount=" + amount + ", commandID=" + commandID + "]";
	}

	
	
	
}
