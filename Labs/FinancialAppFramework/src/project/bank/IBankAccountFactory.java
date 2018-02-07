package project.bank;

import project.framework.interfaces.IAccount;
import project.framework.interfaces.IAccountFactory;


public interface IBankAccountFactory extends IAccountFactory{
	IAccount createAccount(String accountnr, String accountType, String amount);
}
