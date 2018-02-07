package com.asd.domain;

import java.time.LocalDate;
public class AccountEntry {

	// private Date date;

	private LocalDate date;

	private String description;
	private Double amount;
	private Double balance;
	private String fromAccountNumber;
	private String fromPersonName;

	//
	// public Date getDate() {
	// return date;
	// }
	//
	// public void setDate(Date date) {
	// this.date = date;
	// }

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFromAccountNumber() {
		return fromAccountNumber;
	}

	public void setFromAccountNumber(String fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}

	public String getFromPersonName() {
		return fromPersonName;
	}

	public void setFromPersonName(String fromPersonName) {
		this.fromPersonName = fromPersonName;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "AccountEntry [date=" + date + ", description=" + description + ", fromAccountNumber="
				+ fromAccountNumber + ", fromPersonName=" + fromPersonName + ", amount=" + amount + "]";
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

}
