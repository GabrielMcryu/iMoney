package com.gabriel.imoney.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class B2CData {

	@JsonProperty("SenderAccount")
	private String senderAccount;
	
	@JsonProperty("Merchant")
	private String merchant;
	
	@JsonProperty("CommandID")
	private String commandID;
	
	@JsonProperty("Amount")
	private String amount;
	
	@JsonProperty("PartyB")
	private String partyB;
	
	@JsonProperty("Remarks")
	private String remarks;
	
	@JsonProperty("Occassion")
	private String occassion;

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

	public B2CData() {
		
	}

	public B2CData(String senderAccount, String merchant, String commandID, String amount, String partyB, String remarks,
			String occassion) {
		this.senderAccount = senderAccount;
		this.merchant = merchant;
		this.commandID = commandID;
		this.amount = amount;
		this.partyB = partyB;
		this.remarks = remarks;
		this.occassion = occassion;
	}

	@Override
	public String toString() {
		return "B2CData [senderAccount=" + senderAccount + ", merchant=" + merchant + ", commandID=" + commandID
				+ ", amount=" + amount + ", partyB=" + partyB + ", remarks=" + remarks + ", occassion=" + occassion + "]";
	}
	
	
}
