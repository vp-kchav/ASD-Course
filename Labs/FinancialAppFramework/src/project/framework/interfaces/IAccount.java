package project.framework.interfaces;

import java.util.List;

import project.framework.EntryType;

public interface IAccount {
	public void addEntry(IEntry entry);

	public double getCurrentBalance();

	public void addInterest();

	public void generateMonthlyBill();

	public void notifyEmailSending();

	public String getAccountNumber();

	public List<IEntry> getEntryHistory();

	IAccount getAccountByAccountNo(String accountNo);

	boolean updateBalance(String clientName, EntryType type, Double newamount);

	public String get_accountNumber();

	public String getAccountType();

	public Double getAmount();

	void addEntry(IEntry entry, IRule predicate, INotifyFunctor functor);

	public String getMonthlyBillReport();

	public void notifyEmailSending(INotifyFunctor functor_NotifyCustomer);

}
