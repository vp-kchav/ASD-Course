package project.framework.interfaces;

import java.util.Date;

import project.framework.EntryType;

public interface IFinCo {
	public void addAccount(IAccount account2, String customerName);
	public String generateReport(String customerName);
	public void addPersonalAccount(String clientName, IAddress address,
			String accountnr, String accountType, String amount);
	public boolean addEntry(double amount, EntryType type, Date date,
			String accountNo, String customerName);
}
