package com.asd.domain;

/**
 * @author 985246
 *
 */
public class CheckingInterestCalculator implements InterestCalculator {
	/*
	 * @Override public BigDecimal calculateInterest(BigDecimal balance) {
	 * BigDecimal interest; if (balance.compareTo(BigDecimal.valueOf(1000)) < 0)
	 * { interest = balance.multiply(new BigDecimal(0.01)); }else{ interest =
	 * balance.multiply(new BigDecimal(0.05)); } return interest; }
	 */
	public Double calculateInterest(Double balance) {
		Double interest;
		if (balance < 1000) {
			interest = balance * 0.01;
		} else {
			interest = balance * 0.05;
		}
		return interest;
	}

}
