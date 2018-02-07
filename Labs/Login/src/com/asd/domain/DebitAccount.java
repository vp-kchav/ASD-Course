package com.asd.domain;

import java.util.Date;

public class DebitAccount extends Account {
	
	public DebitAccount(InterestCalculator interestCalculator,Customer customer,String accountNumber, Double intialBalance) {
		super(interestCalculator,customer,accountNumber, intialBalance);
		this.setMaxPayment(500.0);
	}

	public DebitAccount(InterestCalculator interestCalculator,Customer customer,String accountNumber ) {
		this(interestCalculator, customer,accountNumber, 0.0);
	}


}
