package com.gabriel.imoney.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AccountEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountId;
	
	private String firstName;
	
	private String lastName;
	
	private int balance;
	
	private String phoneNumber;
	
	private Date birthDate;
	
	private Date createdAt;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public AccountEntity() {
	
	}

	public AccountEntity(Long accountId, String firstName, String lastName, int balance, String phoneNumber,
			Date birthDate, Date createdAt) {
		this.accountId = accountId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
		this.phoneNumber = phoneNumber;
		this.birthDate = birthDate;
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "AccountEntity [accountId=" + accountId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", balance=" + balance + ", phoneNumber=" + phoneNumber + ", birthDate=" + birthDate + ", createdAt="
				+ createdAt + "]";
	}
	
	
}
