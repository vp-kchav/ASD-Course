package project.ccard;

import project.framework.interfaces.IEntry;
import project.framework.interfaces.IRule;

public class CreditRule implements IRule {

	@Override
	public boolean canAdd(IEntry entry, double balance) {
		if(entry.getAmount()>400) return false;
		return true;
	}

	@Override
	public boolean canCreateAccount(String clientName, String accountNumber) {
		// TODO Auto-generated method stub
		return false;
	}

}
