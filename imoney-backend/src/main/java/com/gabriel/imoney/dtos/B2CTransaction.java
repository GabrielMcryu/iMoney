package com.gabriel.imoney.dtos;

public class B2CTransaction {

	private String senderAccount;
	
	private String merchant;
	
	private String commandID;
	
	private String amount;
	
	private String partyB;
	
	private String remarks;
	
	private String occassion;
	
	private String conversationID;
	
	private String originatorConversationID;
	
	private String responseCode;
	
	private String responseDescription;

	public String getSenderAccount() {
		return senderAccount;
	}

	public void setSenderAccount(String senderAccount) {
		this.senderAccount = senderAccount;
	}

	public String getMerchant() {
		return merchant;
	}

	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}

	public String getCommandID() {
		return commandID;
	}

	public void setCommandID(String commandID) {
		this.commandID = commandID;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPartyB() {
		return partyB;
	}

	public void setPartyB(String partyB) {
		this.partyB = partyB;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getOccassion() {
		return occassion;
	}

	public void setOccassion(String occassion) {
		this.occassion = occassion;
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

	public B2CTransaction() {

	}

	public B2CTransaction(String senderAccount, String merchant, String commandID, String amount, String partyB,
			String remarks, String occassion, String conversationID, String originatorConversationID,
			String responseCode, String responseDescription) {
		this.senderAccount = senderAccount;
		this.merchant = merchant;
		this.commandID = commandID;
		this.amount = amount;
		this.partyB = partyB;
		this.remarks = remarks;
		this.occassion = occassion;
		this.conversationID = conversationID;
		this.originatorConversationID = originatorConversationID;
		this.responseCode = responseCode;
		this.responseDescription = responseDescription;
	}

	@Override
	public String toString() {
		return "B2CTransaction [senderAccount=" + senderAccount + ", merchant=" + merchant + ", commandID=" + commandID
				+ ", amount=" + amount + ", partyB=" + partyB + ", remarks=" + remarks + ", occassion=" + occassion
				+ ", conversationID=" + conversationID + ", originatorConversationID=" + originatorConversationID
				+ ", responseCode=" + responseCode + ", responseDescription=" + responseDescription + "]";
	}
	
	
}
