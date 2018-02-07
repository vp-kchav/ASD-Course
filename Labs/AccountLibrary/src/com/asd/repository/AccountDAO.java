package com.asd.repository;

import java.util.List;

import com.asd.domain.Account;

public interface AccountDAO {
	
	void saveAccount(Account account);

	void updateAccount(Account account);

	Account loadAccount(String accountNumber);

	List<Account> getAllAccounts();
}
