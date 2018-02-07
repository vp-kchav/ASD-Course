package project.ccard;

import java.util.Date;

public class Silver extends CreditAccount {

	private double MONTHLY_INTEREST = 0.08d;
	private double MONTHLY_PAYMENT = 0.12d;
	
	public Silver(String accountNumber, Date expDate) {
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

}
