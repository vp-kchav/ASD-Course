package project.framework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import project.framework.interfaces.IAccount;
import project.framework.interfaces.ICustomer;
import project.framework.interfaces.IDataStore;

public enum DataStore implements IDataStore {
	INSTANCE;

	private Map<String, ICustomer> customers = new HashMap<>();

	private String reportDate;

	public void addCustomer(ICustomer customer) {
		this.customers.put(customer.getName(), customer);
	}

	public void addAccount(IAccount account, String customerName) {
		ICustomer customer = customers.get(customerName);
		//customer.getAccounts().add(account);
		customer.addAccount(account);
		customers.put(customerName, customer);
	}

	public Map<String, ICustomer> getCustomers() {
		return this.customers;
	}

	public ICustomer getCustomer(String customerName) {
		return customers.get(customerName);
	}

	public IAccount getAccountByAccountNo(String customerName, String accountNo) {
		ICustomer customer = customers.get(customerName);
		if (customer == null) {
			return null;
		}
		for (Iterator<IAccount> it = customer.getAccounts().iterator(); it
				.hasNext();) {
			IAccount account = it.next();
			if (account.getAccountNumber().equals(accountNo))
				return account;
		}
		return null;
	}

//	public ICustomer getCustomerByAccount(IAccount account) {
//		ICustomer customer = customers.get(account.get_accountNumber());
//		if (customer == null) {
//			return null;
//		}
//		for (Iterator<IAccount> it = customer.getAccounts().iterator(); it
//				.hasNext();) {
//			IAccount account2 = it.next();
//			if (account2.equals(account))
//				return customer;
//		}
//		return null;
//	}

	public String getReportData() {
		return this.reportDate;
	}

	public void setReportData(String value) {
		this.reportDate = value;
	}

	public ICustomer getCustomerByAccount(String clientName) {
		ICustomer customer = customers.get(clientName);
		return customer;
	}
}
