package project.framework;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.logging.Logger;

import project.framework.interfaces.IAccount;
import project.framework.interfaces.IEntry;
import project.framework.interfaces.INotifyFunctor;
import project.framework.interfaces.IRule;

public class Account extends Observable implements IAccount {
	private static final Logger log = Logger
			.getLogger("Account.class.getName()");

	private List<IEntry> entries = new ArrayList<>();
	private String _accountNumber;
	private String accountType;
	protected Double amount = 0d;

	public Account(String _accountNumber, String accountType,
			String amountDeposit) {
		this._accountNumber = _accountNumber;
		this.accountType = accountType;
		this.amount = Double.parseDouble(amountDeposit);
	}

	public Account() {
	}

	public Account(String accountNumber) {
		this._accountNumber = accountNumber;
	}

	@Override
	
	public void addEntry(IEntry entry) {
		entries.add(entry); 
	}

	public double getCurrentBalance() {
		double balance=0d;
		for(IEntry entry:entries)
		{
			if (entry.getType()==EntryType.DEPOSIT)
				
				balance+=entry.getAmount();
			else
				balance-=entry.getAmount();
		}
		
		return balance;
	}

	// public void addInterest() {
	// } // Abstract method need to be implemented bank manager class.

	public void notifyEmailSending() {
		setChanged();
		notifyObservers();
	}

	public String getAccountNumber() {
		return this._accountNumber;
	}

	public List<IEntry> getEntryHistory() {
		return this.entries;
	}

	@Override
	public void generateMonthlyBill() {
		// TODO Auto-generated method stub

	}

	@Override
	public IAccount getAccountByAccountNo(String accountNo) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void addInterest() {
		// TODO Auto-generated method stub

	}

	public String get_accountNumber() {
		return _accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public Double getAmount() {
		return amount;
	}

	@Override
	public void addEntry(IEntry entry, IRule predicate,
			INotifyFunctor functor) {
		if (entry != null) {
			if (predicate.canAdd(entry, getCurrentBalance()))
				entries.add(entry);
			else
				notifyEmailSending(functor);
		}
	}

	@Override
	public String toString() {
		return "Account [entries=" + entries.toString() + ", _accountNumber="
				+ _accountNumber + ", accountType=" + accountType + ", amount="
				+ amount + "]";
	}
	
	public void notifyEmailSending(INotifyFunctor functor) {
		setChanged();
		notifyObservers(functor);
	}

	@Override
	public String getMonthlyBillReport() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateBalance(String clientName, EntryType type,
			Double newamount) {
		// TODO Auto-generated method stub
		return false;
	}

}
