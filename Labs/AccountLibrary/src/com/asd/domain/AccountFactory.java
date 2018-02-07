package com.asd.domain;

public interface AccountFactory {
	Account create(Customer customer,
			String accountType,
			String accountNumber,
			Double initialBalance
			);
}
