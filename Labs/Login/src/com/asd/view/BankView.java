package com.asd.view;

import java.util.List;

import com.asd.domain.Account;
import com.asd.domain.Customer;
import com.asd.service.AccountService;
import com.asd.visitor.BankReportGenerator;

public class BankView implements AccountView {
	AccountService accountService;

	public BankView(AccountService accountService) {
		this.accountService = accountService;
	}

	@Override
	public void createAccount(Customer customer, String accountType, String accountNumber, double balance) {
		accountService.createAccount(customer, accountType, accountNumber, balance);
	}

	@Override
	public void deposit(String accountNumber, double amount) {
		accountService.deposit(accountNumber, amount);
	}

	@Override
	public void withdraw(String accountNumber, double amount) {
		accountService.withdraw(accountNumber, amount);
	}

	@Override
	public List<Account> getAllAccounts() {
		return accountService.getAllAccounts();
	}

	@Override
	public void addInterest() {
		accountService.addInterest();
	}

	@Override	
	public String generateReport(){
		return accountService.generateReport(new BankReportGenerator());
	}
	
	public Account getAccount(String accountNumber){
		return this.accountService.getAccount(accountNumber);		
	}
}

