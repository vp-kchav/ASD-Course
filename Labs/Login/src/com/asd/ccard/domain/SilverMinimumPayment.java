package com.asd.ccard.domain;

public class SilverMinimumPayment implements MinimumPaymentCalculator {

	@Override
	public Double calculateMinimumPayment(Double balance) {
		Double minimumPayment = balance * 0.12;
		
		return minimumPayment;
	}
	

}
