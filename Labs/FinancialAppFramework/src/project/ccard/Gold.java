package project.ccard;

import java.util.Date;

public class Gold extends CreditAccount {

	private double MONTHLY_INTEREST = 0.06d;
	private double MONTHLY_PAYMENT = 0.1d;
	
	public Gold(String accountNumber, Date expDate) {
		super(accountNumber, expDate);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getMonthlyInterest() {
		// TODO Auto-generated method stub
		return  this.MONTHLY_INTEREST;
	}

	@Override
	public double getMonthlyPayment() {
		// TODO Auto-generated method stub
		return this.MONTHLY_PAYMENT;
	}
	
	
}
