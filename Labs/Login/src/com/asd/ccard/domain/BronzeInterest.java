package com.asd.ccard.domain;

import com.asd.domain.InterestCalculator;

public class BronzeInterest implements InterestCalculator {

	@Override
	public Double calculateInterest(Double balance) {
		Double interest;
		
		interest = balance * 0.10;
		
		return interest;
		
	}


	
}
