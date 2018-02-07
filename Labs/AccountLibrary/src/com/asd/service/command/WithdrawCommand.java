package com.asd.service.command;

import com.asd.domain.Account;

public class WithdrawCommand implements Command<Account, Double> {

	Account account;
	Double amount;
	Boolean executed = false;

	public WithdrawCommand(Account account, Double amount) {
		this.account = account;
		this.amount = amount;
	}

	@Override
	public void execute() {
		if (!executed) {
			account.withdraw(amount);
			executed = true;
		}
	}

	public void undo() {
		if (executed) {
			account.deposit(amount);
			executed = false;
		}
	}

}
