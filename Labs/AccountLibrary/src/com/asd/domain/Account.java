package com.asd.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.asd.visitor.ReportVisitor;

/**
 * @author 985246
 * @param <T>
 *
 */
public abstract class Account implements Consumer<ReportVisitor> {

	private String accountNumber;
	private Customer customer;
	private Double balance;

	private Double maxPayment;

	private InterestCalculator accountInterestCalculator;
	private List<AccountEntry> accountEntries = new ArrayList<AccountEntry>();

	public Account(InterestCalculator interestCalculator, Customer customer, String accountNumber) {
		this(interestCalculator, customer, accountNumber, 0.0);
	}

	public Account(InterestCalculator interestCalculator, Customer customer, String accountNumber,
			Double intialBalance) {
		super();
		this.accountNumber = accountNumber;
		this.balance = intialBalance;
		this.customer = customer;
	}

	public void deposit(Double amount) {
		if (amount.compareTo(0.0) <= 0) {
			throw new IllegalArgumentException("Invalid deposit amount.");
		}

		this.balance += amount;

		AccountEntry accountEntry = new AccountEntry();
		accountEntry.setAmount(amount);
		accountEntry.setDate(LocalDate.now());
		accountEntry.setDescription("Deposit is performed.");

		this.accountEntries.add(accountEntry);
	}

	@Override
	public void accept(ReportVisitor v) {
		v.visit(this);
	}

	public Double calculateInterest() {
		Double interest = accountInterestCalculator != null ? this.accountInterestCalculator.calculateInterest(balance)
				: 0.0;
		return interest;
	}

	public void withdraw(Double amount) {
		this.setBalance(this.getBalance() - amount);
		AccountEntry accountEntry = new AccountEntry();
		accountEntry.setAmount(amount);
		accountEntry.setDate(LocalDate.now());
		accountEntry.setDescription("Withdraw is performed.");
		addAccountEntry(accountEntry);
	}

	public void addInterest() {
		double balance = this.getBalance();
		double interest = this.calculateInterest();
		balance += interest;
		AccountEntry accountEntry = new AccountEntry();
		accountEntry.setAmount(balance);
		accountEntry.setDate(LocalDate.now());
		accountEntry.setDescription("Interest is added.");
		this.addAccountEntry(accountEntry);
		this.setBalance(balance);
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double amount) {
		this.balance = amount;
	}

	public InterestCalculator getAccountInterestCalculator() {
		return accountInterestCalculator;
	}

	public void setAccountInterestCalculator(InterestCalculator accountInterestCalculator) {
		this.accountInterestCalculator = accountInterestCalculator;
	}

	public List<AccountEntry> getAccountEntries() {
		return accountEntries;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", customer=" + customer + ", balance=" + balance + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		return true;
	}

	public void addAccountEntry(AccountEntry accountEntry) {
		this.accountEntries.add(accountEntry);
	}

	public Double getMaxPayment() {
		return maxPayment;
	}

	public void setMaxPayment(Double maxPayment) {
		this.maxPayment = maxPayment;
	}

	public boolean needWithDrawlNotification(Double amount) {
		if (!this.getCustomer().isPerson()) {
			return true;
		} else if (this.getBalance() < 0.0 && amount > this.getMaxPayment()) {
			return true;
		} else
			return false;
	}

	public boolean needDepositNotification(Double amount) {
		if (!this.getCustomer().isPerson()) {
			return true;
		} else if (amount != null && this.getMaxPayment() > amount) {
			return true;
		} else
			return false;
	}

}
