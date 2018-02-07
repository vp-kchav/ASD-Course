package project.bank;

import java.util.logging.Logger;

import project.bank.Bank.Account_Type;
import project.framework.interfaces.IAccount;

public class BankAccountFactory implements IBankAccountFactory {
	private static final Logger log = Logger
			.getLogger("BankAccountFactory.class.getName()");
	private BankAccountFactory() {
	}

	private static BankAccountFactory instance = new BankAccountFactory();

	public static BankAccountFactory getInstance() {
		if (instance == null)
			instance = new BankAccountFactory();
		return instance;
	}

	private static Account_Type readAccountType(String accountType) {
		if (accountType.equalsIgnoreCase("Checking"))
			return Account_Type.CHECKING;
		else
			return Account_Type.SAVING;
	}
	@Override
	public IAccount createAccount(String accountnr, String accountType,
			String amount) {
		Account_Type acct = readAccountType(accountType);
		switch (acct) {
		case CHECKING:
			log.info("Checking account created");
			return new Checking(accountnr, accountType, amount);
		default:
			log.info("Saving account created");
			return new Saving(accountnr, accountType, amount);
		}
	}

	@Override
	public IAccount createAccount() {
		// TODO Auto-generated method stub
		return null;
	}

}
