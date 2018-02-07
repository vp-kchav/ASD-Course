package com.asd.service.command;

import com.asd.domain.Account;

public class DepositeCommand implements Command<Account, Double> {

	Account account;
	Double amount;
	Boolean executed = false;

	public DepositeCommand(Account account, Double amount) {
		this.account = account;
		this.amount = amount;
	}

	@Override
	public void execute() {
		if (!executed) {
			account.deposit(amount);
			this.executed = true;
		}
	}

	public void undo() {
		if (executed) {
			account.withdraw(amount);
			this.executed = false;
		}
	}

}
