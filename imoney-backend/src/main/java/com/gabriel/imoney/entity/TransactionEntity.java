package com.gabriel.imoney.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TransactionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactionId;
	
	private String senderName;
	private int accountNumber;
	private int amount;
	private String merchant;
	private Date createdAt;
	
	public Long getTransactionId() {
		return transactionId;
	}
	
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	
	public String getSenderName() {
		return senderName;
	}
	
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getMerchant() {
		return merchant;
	}
	
	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public TransactionEntity() {
		
	}

	public TransactionEntity(Long transactionId, String senderName, int accountNumber, int amount, String merchant,
			Date createdAt) {
		this.transactionId = transactionId;
		this.senderName = senderName;
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.merchant = merchant;
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", senderName=" + senderName + ", accountNumber="
				+ accountNumber + ", amount=" + amount + ", merchant=" + merchant + ", createdAt=" + createdAt + "]";
	}
	
	
	
}
