package com.asd.ccard.domain;


import java.time.LocalDate;
import java.util.Date;

import com.asd.domain.Account;
import com.asd.domain.AccountEntry;
import com.asd.domain.Customer;
import com.asd.domain.InterestCalculator;


public class CreditAccount extends Account{
	
	MinimumPaymentCalculator minimumPayment;
	
	public CreditAccount(InterestCalculator interestCalculator, Customer customer,String accountNumber,MinimumPaymentCalculator minimumPayment) {
		super(interestCalculator,customer, accountNumber);
		this.minimumPayment = minimumPayment;
		this.setMaxPayment(400.0); 		
	}

	
	@Override
	public void addInterest() {
		Double balance = this.getBalance();
		double interest = this.calculateInterest();
		balance += interest;
		AccountEntry accountEntry = new AccountEntry();
		accountEntry.setAmount(balance);
		accountEntry.setDate(LocalDate.now());
		accountEntry.setDescription("Interest is added.");
		this.addAccountEntry(accountEntry);
		this.setBalance(balance);		
		
	}
	
	@Override
	public void deposit(Double amount) {
		Double minimumPayment = getMinimumPayment(this.getBalance());
		if (amount.compareTo(Math.abs(minimumPayment)) < 0) {
			throw new IllegalArgumentException("Invalid deposit amount.");
		}
		else super.deposit(amount);
	}

	public Double getMinimumPayment(Double balance){
		return minimumPayment.calculateMinimumPayment(balance);
		
	}



	
}
