package project.framework;

import project.framework.interfaces.IAccount;
import project.framework.interfaces.IEntry;
import project.framework.interfaces.IRule;

public class AccountRule implements IRule {
	DataStore store = DataStore.INSTANCE;

	@Override
	public boolean canAdd(IEntry entry, double balance) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Checks if the account number is already used or not.
	 */
	@Override
	public boolean canCreateAccount(String clientName, String accountNumber) {
		IAccount account = store.getAccountByAccountNo(clientName, accountNumber);
		if (account == null)
			return true;
		return false;
	}
}
