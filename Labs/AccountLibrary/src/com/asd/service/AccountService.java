package com.asd.service;

import java.util.Date;
import java.util.List;

import com.asd.domain.Account;
import com.asd.domain.Customer;
import com.asd.visitor.ReportVisitor;

public interface AccountService extends Observerable {

	void addInterest();
	
	void deposit(String accountNumber, Double amount);

	void withdraw(String accountNumber, Double amount);
		
	void createAccount(Customer customer,String accountType, String accountNumber , Double balance);

	String generateReport(ReportVisitor visitor);	
	
	List<Account> getAllAccounts();


	Account getAccount(String accountNumber);
		
	void transferFunds(Account source, Account target, Double amount);
	
	void undoLastTransaction(Account account);

	void redoLastTransaction(Account account);
	
}
