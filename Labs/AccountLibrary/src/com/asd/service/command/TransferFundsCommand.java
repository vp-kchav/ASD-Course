package com.asd.service.command;

import com.asd.domain.Account;

public class TransferFundsCommand implements Command<Account, Double> {
	Account source;
	Account target;
	Double amount;
	Boolean executed = false;

	public TransferFundsCommand(Account source, Account target, Double amount) {
		this.source = source;
		this.target = target;
		this.amount = amount;
	}

	@Override
	public void execute() {
		if (!executed) {
			source.withdraw(amount);
			target.deposit(amount);
			executed = true;
		}
	}

	@Override
	public void undo() {
		if (executed) {
			target.withdraw(amount);
			source.deposit(amount);
			executed = false;
		}
	}

}
