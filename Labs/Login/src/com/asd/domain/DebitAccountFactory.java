package com.asd.domain;

public class DebitAccountFactory implements AccountFactory {

	@Override
	public Account create(Customer customer, String accountType, String accountNumber, Double balance)
			throws IllegalArgumentException {
		Account account = null;
		if (accountType != null) {
			if (accountType.equals("CHECKING")) {
				account = new CheckingAccount(customer,accountNumber,balance);
			} else if (accountType.equals("SAVING")) {
				account = new SavingAccount(customer,accountNumber,balance);
			}
		} else {
			throw new IllegalArgumentException("Invalid account type.");
		}
		System.out.println(account);
		return account;
	}

}
