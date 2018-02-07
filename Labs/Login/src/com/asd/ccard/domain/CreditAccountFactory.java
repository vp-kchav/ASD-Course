package com.asd.ccard.domain;

import com.asd.domain.Account;
import com.asd.domain.AccountFactory;
import com.asd.domain.Customer;

public class CreditAccountFactory implements AccountFactory {

	@Override
	public Account create(Customer customer, String accountType, String accountNumber, Double balance) {
		Account account = null;
		if (accountType != null) {
			if (accountType.equals("SILVER")) {
				account = new SilverAccount(customer,accountNumber);
			} else if (accountType.equals("GOLD")) {
				account = new GoldAccount(customer,accountNumber);
			}else if (accountType.equals("BRONZE")) {
				account = new BronzeAccount(customer,accountNumber);
			}
		} else {
			throw new IllegalArgumentException("Invalid account type.");
		}
		System.out.println(account);
		return account;
	}

	

	

}
