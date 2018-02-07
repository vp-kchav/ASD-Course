package project.bank;

public class Checking extends BankAccount{

	private static final Double INTEREST_RATE = 0.01;
	public Checking(String accountnr, String accountType, String amountDeposit) {
		super(accountnr, accountType, amountDeposit);
	}

	public Checking() {
		super();
	}
	
	@Override
	public void addInterest() {
		amount += amount * INTEREST_RATE;
		System.out.println("Checking amount = " + amount);
	}

}
