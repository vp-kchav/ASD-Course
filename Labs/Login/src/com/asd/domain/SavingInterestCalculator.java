package com.asd.domain;

/**
 * @author 985246
 *
 */
/**
 * @author 985246
 *
 */
public class SavingInterestCalculator implements InterestCalculator {
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.paulos.domain.AccountInterest#calculateInterest(java.math.BigDecimal)
	 * If balance < 1000 then you get 1% interest If balance > 1000 and balance
	 * < 5000 then you get 2% interest If balance > 5000 then you get 4%
	 * interest
	 * 
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
