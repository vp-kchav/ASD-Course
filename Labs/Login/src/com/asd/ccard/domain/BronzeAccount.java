package com.asd.ccard.domain;

import com.asd.domain.Customer;
import com.asd.domain.InterestCalculator;

public class BronzeAccount extends CreditAccount {

	public BronzeAccount(Customer customer,String accountNumber) {
		super(new SilverInterest(), customer, accountNumber,new BronzeMinimumPayment());
	}

	

	
}
