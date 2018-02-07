package com.asd.service;

import com.asd.domain.Account;

public class EmailSender implements BalanceChangeObserver{

	public void update(Account account) {
		System.out.println("Sending email to: " + account.getCustomer().getEmail());
		System.out.println("Balance Changed to: "+ account.getBalance());
	}

}
