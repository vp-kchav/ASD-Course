package com.asd.repository;

import java.util.ArrayList;
import java.util.List;

import com.asd.domain.Account;

public class MockAccountDAO implements AccountDAO {
	public static final List<Account> accounts = new ArrayList<Account>();

	public void saveAccount(Account account) {
		accounts.add(account);
	}

	public void updateAccount(Account account) {
	}

	public Account loadAccount(final String accountNumber) {
		Account found = null;
		found = accounts.stream().filter(account -> account.getAccountNumber().equals(accountNumber)).findFirst().get();
		return found;
	}

	public List<Account> getAllAccounts() {
		return this.accounts;
	}

}
