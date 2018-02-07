package com.asd.service;

import com.asd.domain.Account;

public interface Observerable {
	
	void notify(final Account balance);

	void removeBalanceChangeObserver(BalanceChangeObserver observer);

	void addBalanceChangeObserver(BalanceChangeObserver observer);
}
