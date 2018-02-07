package com.asd.ccard.domain;

public class BronzeMinimumPayment implements MinimumPaymentCalculator {

	@Override
	public Double calculateMinimumPayment(Double balance) {
		Double minimumPayment = balance * 0.14;
		
		return minimumPayment;
	}
	

}
