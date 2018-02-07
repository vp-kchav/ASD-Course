package com.asd.service;

import com.asd.domain.Account;

public interface BalanceChangeObserver {
	void update(Account account);
}
