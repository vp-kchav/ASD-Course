package project.ccard;

import java.util.*;
public class Bronze extends CreditAccount {

	private double MONTHLY_INTEREST = 0.1d;
	private double MONTHLY_PAYMENT = 0.14d;
	private String expDate;
	public Bronze(String accountNumber, Date expDate) {
		super(accountNumber, expDate);
	}

	@Override
	public double getMonthlyInterest() {
		return this.MONTHLY_INTEREST;
	}

	@Override
	public double getMonthlyPayment() {
		return this.MONTHLY_PAYMENT;
	}
	
	public String getExpDate(){ return this.expDate;}
}
