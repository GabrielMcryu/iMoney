package com.gabriel.imoney.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class C2bEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long c2bId;
	
	private String senderName;
	
	private String merchant;
	
	private Long ReceiverAccountNumber;
	
	private String shortCode;
	
	private String msisdn;
	
	private String billRefNumber;
	
	private String amount;
	
	private String commandID;
	
	private String responseDescription;
	
	private String responseCode;
	
	private String originatorCoversationID;

	public Long getC2bId() {
		return c2bId;
	}

	public void setC2bId(Long c2bId) {
		this.c2bId = c2bId;
	}

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

	public Long getReceiverAccountNumber() {
		return ReceiverAccountNumber;
	}

	public void setReceiverAccountNumber(Long receiverAccountNumber) {
		ReceiverAccountNumber = receiverAccountNumber;
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

	public C2bEntity() {
		
	}

	public C2bEntity(Long c2bId, String senderName, String merchant, Long receiverAccountNumber, String shortCode,
			String msisdn, String billRefNumber, String amount, String commandID, String responseDescription,
			String responseCode, String originatorCoversationID) {
		this.c2bId = c2bId;
		this.senderName = senderName;
		this.merchant = merchant;
		ReceiverAccountNumber = receiverAccountNumber;
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
		return "C2bEntity [c2bId=" + c2bId + ", senderName=" + senderName + ", merchant=" + merchant
				+ ", ReceiverAccountNumber=" + ReceiverAccountNumber + ", shortCode=" + shortCode + ", msisdn=" + msisdn
				+ ", billRefNumber=" + billRefNumber + ", amount=" + amount + ", commandID=" + commandID
				+ ", responseDescription=" + responseDescription + ", responseCode=" + responseCode
				+ ", originatorCoversationID=" + originatorCoversationID + "]";
	}

	
}
