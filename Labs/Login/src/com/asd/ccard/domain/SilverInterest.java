package com.asd.ccard.domain;

import com.asd.domain.InterestCalculator;

public class SilverInterest implements InterestCalculator {

	@Override
	public Double calculateInterest(Double balance) {
		Double interest;
		
		interest = balance * 0.06;
		
		return interest;
		
	}


	
}
