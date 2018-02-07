package project.ccard;

import java.util.Date;

import project.framework.interfaces.IAccountFactory;

public interface ICreditFactory extends IAccountFactory {
	public CreditAccount getInstance(String type, String accountNumber, Date expDate);
}
