package com.asd.ccard.domain;

public class GoldMinimumPayment implements MinimumPaymentCalculator {

	@Override
	public Double calculateMinimumPayment(Double balance) {
		Double minimumPayment = balance * 0.10;
		
		return minimumPayment;
	}
	

}
