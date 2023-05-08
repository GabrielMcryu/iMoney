package com.gabriel.imoney.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ITransactionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iTransation;
	
	private Long senderAccount;
	
	private Long receiverAccount;
	
	private int amount;
	
	private Date createdAt;

	public Long getiTransation() {
		return iTransation;
	}

	public void setiTransation(Long iTransation) {
		this.iTransation = iTransation;
	}

	public Long getSenderAccount() {
		return senderAccount;
	}

	public void setSenderAccount(Long senderAccount) {
		this.senderAccount = senderAccount;
	}

	public Long getReceiverAccount() {
		return receiverAccount;
	}

	public void setReceiverAccount(Long receiverAccount) {
		this.receiverAccount = receiverAccount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public ITransactionEntity() {
	
	}

	public ITransactionEntity(Long iTransation, Long senderAccount, Long receiverAccount, int amount, Date createdAt) {
		this.iTransation = iTransation;
		this.senderAccount = senderAccount;
		this.receiverAccount = receiverAccount;
		this.amount = amount;
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "ITransactionEntity [iTransation=" + iTransation + ", senderAccount=" + senderAccount
				+ ", receiverAccount=" + receiverAccount + ", amount=" + amount + ", createdAt=" + createdAt + "]";
	}
	
	
	
}
