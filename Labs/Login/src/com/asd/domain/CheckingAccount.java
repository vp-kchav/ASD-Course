package com.asd.domain;

public class CheckingAccount extends DebitAccount {

	public CheckingAccount(Customer customer,String accountNumber) {
		this(customer,accountNumber, 0.0);
	}

	public CheckingAccount(Customer customer,String accountNumber, double d) {
		super(new CheckingInterestCalculator(), customer,accountNumber, d);
	}
}
