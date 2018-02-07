package com.asd.view;

import java.util.List;

import com.asd.domain.Account;
import com.asd.domain.Customer;

public interface AccountView {
	
	void createAccount(Customer customer,String accountType, String accountNumber, double balance);

	void addInterest();

	void deposit(String accountNumber, double amount);

	void withdraw(String accountNumber, double amount);

	List<Account> getAllAccounts();
	
	Account getAccount(String accountNumber);
	
	String generateReport();
}
