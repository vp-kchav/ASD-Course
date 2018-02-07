package com.asd.service;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.asd.domain.Account;
import com.asd.domain.AccountFactory;
import com.asd.domain.Customer;
import com.asd.repository.AccountDAO;
import com.asd.service.command.Command;
import com.asd.service.command.DepositeCommand;
import com.asd.service.command.TransferFundsCommand;
import com.asd.service.command.WithdrawCommand;
import com.asd.visitor.ReportVisitor;

public class AccountServiceImpl implements AccountService {

	private AccountDAO accountDAO;

	private AccountFactory accountFactory;

	private List<BalanceChangeObserver> observers = new ArrayList<BalanceChangeObserver>();

	private Map<Account, Command> transactions = new Hashtable<>();

	@Override
	public void createAccount(Customer customer, String accountType, String accountNumber, Double balance) {
		Account account = accountFactory.create(customer, accountType, accountNumber, balance);
		accountDAO.saveAccount(account);
	}

	@Override
	public void undoLastTransaction(Account account) {
		Command<Account, Double> command = transactions.get(account);

		if (command == null) {
			throw new IllegalStateException("Unsuported operation.");
		}

		command.undo();
	}

	@Override
	public void redoLastTransaction(Account account) {
		Command<Account, Double> command = transactions.get(account);
		if (command == null) {
			throw new IllegalStateException("Unsuported operation.");
		}
		command.execute();
	}

	public void notify(final Account account) {
		this.observers.forEach(o -> o.update(account));
	}

	public void addBalanceChangeObserver(BalanceChangeObserver observer) {
		this.observers.add(observer);
	}

	public void removeBalanceChangeObserver(BalanceChangeObserver observer) {
		this.observers.remove(observer);
	}

	public void createAccount(Account account) {
		this.accountDAO.saveAccount(account);
	}

	public void deposit(String accountNumber, Double amount) {
		Account account = this.accountDAO.loadAccount(accountNumber);

		Command<Account, Double> depositCommand = new DepositeCommand(account, amount);
		this.transactions.put(account, depositCommand);
		depositCommand.execute();

		this.accountDAO.updateAccount(account);
		if (account.needDepositNotification(amount)) {
			this.notify(account);
		}
	}

	public void withdraw(String accountNumber, Double amount) {
		Account account = this.accountDAO.loadAccount(accountNumber);

		Command<Account, Double> withdrawCommand = new WithdrawCommand(account, amount);
		this.transactions.put(account, withdrawCommand);
		withdrawCommand.execute();

		this.accountDAO.updateAccount(account);
		if (account.needWithDrawlNotification(amount)) {
			this.notify(account);
		}
	}

	@Override
	public void addInterest() {
		List<Account> accounts = this.getAllAccounts();
		accounts.forEach(account -> {
			this.addInterest(account);
		});
	}

	public void transferFunds(Account source, Account target, Double amount) {
		Command<Account, Double> transferFundsCommand = new TransferFundsCommand(source, target, amount);
		this.transactions.put(source, transferFundsCommand);
		transferFundsCommand.execute();
		this.notify(source);
		this.notify(target);
	}

	public List<Account> getAllAccounts() {
		return this.accountDAO.getAllAccounts();
	}

	public Account getAccount(String id) {
		return this.accountDAO.loadAccount(id);
	}

	private void addInterest(Account account) {
		account.addInterest();
	}

	@Override
	public String generateReport(ReportVisitor visitor) {
		List<Account> accounts = this.getAllAccounts();		
		
		accounts.forEach(account->{account.accept(visitor);});

		return visitor.getReport();
	}

	public AccountServiceImpl(AccountDAO accountDao,AccountFactory accountFactory) {
		this.accountFactory = accountFactory;
		this.accountDAO = accountDao;
	}

	public AccountDAO getAccountDAO() {
		return accountDAO;
	}


}
