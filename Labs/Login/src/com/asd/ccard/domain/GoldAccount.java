package com.asd.ccard.domain;

import com.asd.domain.Customer;
import com.asd.domain.InterestCalculator;

public class GoldAccount extends CreditAccount {

	public GoldAccount(Customer customer,String accountNumber) {
		super(new SilverInterest(), customer, accountNumber,new GoldMinimumPayment());
		
	}

	

	
}
