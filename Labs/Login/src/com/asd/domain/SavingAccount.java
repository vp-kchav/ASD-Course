package com.asd.domain;

public class SavingAccount extends DebitAccount {
	public SavingAccount(Customer customer,String accountNumber) {
		this(customer,accountNumber, 0.0);
	}

	public SavingAccount(Customer customer,String accountNumber, double d) {
		super(new SavingInterestCalculator(), customer,accountNumber, d);
	}

}
