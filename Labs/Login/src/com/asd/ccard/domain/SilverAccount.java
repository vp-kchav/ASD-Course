package com.asd.ccard.domain;

import com.asd.domain.Customer;


public class SilverAccount extends CreditAccount {

	public SilverAccount(Customer customer,String accountNumber) {
		super(new SilverInterest(), customer,accountNumber, new SilverMinimumPayment());
		
	}

	

	
}
