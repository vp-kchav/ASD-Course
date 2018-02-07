package project.framework;

import project.framework.interfaces.IAccount;
import project.framework.interfaces.IAccountFactory;

public class AccountFactory implements IAccountFactory {
	private AccountFactory() {
	}

	private static AccountFactory instance = new AccountFactory();

	public static AccountFactory getInstance() {
		if (instance == null)
			instance = new AccountFactory();
		return instance;
	}

	@Override
	public IAccount createAccount() {
		return new Account();
	}
	
	

}
