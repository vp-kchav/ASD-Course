package com.asd.ccard.domain;

import com.asd.domain.InterestCalculator;

public class GoldInterest implements InterestCalculator {

	@Override
	public Double calculateInterest(Double balance) {
		Double interest;
		
		interest = balance * 0.08;
		
		return interest;
		
	}


	
}
