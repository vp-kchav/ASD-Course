package com.asd.ccard.view;

import java.util.List;

import com.asd.ccard.domain.CreditCardAccountVisitor;
import com.asd.domain.Account;
import com.asd.domain.Customer;
import com.asd.service.AccountService;
import com.asd.view.AccountView;

public class CreditCardView implements AccountView{
	
	
	AccountService accountService;

	public CreditCardView(AccountService accountService) {	
		this.accountService = accountService;
	}

	@Override
	public void createAccount(Customer customer, String accountType, String accountNumber, double balance) {
		// TODO Auto-generated method stub
		accountService.createAccount(customer, accountType, accountNumber, balance);
		
	}

	@Override
	public void addInterest() {
		accountService.addInterest();
		
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
	public Account getAccount(String accountNumber) {
		return accountService.getAccount(accountNumber);
	}
	@Override	
	public String generateReport(){
		return accountService.generateReport(new CreditCardAccountVisitor());
	}

	@Override
	public String toString() {
		return "CreditCardView [accountService=" + accountService + "]";
	}
	

}
