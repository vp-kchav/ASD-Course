package project.bank;

public class Saving extends BankAccount{
	private static final Double INTEREST_RATE = 0.0325;
	public Saving(String accountnr, String accountType, String amountDeposit) {
		super(accountnr, accountType, amountDeposit);
		// TODO Auto-generated constructor stub
	}

	public Saving() {
		super();
	}
	
	@Override
	public void addInterest() {
		amount += amount * INTEREST_RATE;
		System.out.println("Saving amount = " + amount);
	}
}
