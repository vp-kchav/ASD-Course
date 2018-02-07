package project.framework;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import project.bank.CustomerType;
import project.framework.interfaces.IAccount;
import project.framework.interfaces.IAddress;
import project.framework.interfaces.ICustomer;
import project.framework.interfaces.INotifyFunctor;

public class Customer implements ICustomer {
	private String name;

	private List<IAddress> addresses;
	private List<IAccount> accounts;
	private IAccount account;

	private CustomerType type;

	public Customer(String name, CustomerType type, IAddress address,
			IAccount account) {
		this.name = name;
		addresses = new ArrayList<>();
		accounts = new ArrayList<>();
		this.account = account;
		addresses.add(address);
		accounts.add(account);
		this.type = type;
	}

	public Customer(String name, IAddress address, IAccount account) {
		this.name = name;
		addresses = new ArrayList<>();
		accounts = new ArrayList<>();
		this.account = account;
		addresses.add(address);
		accounts.add(account);
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addAccount(IAccount account) {
		accounts.add(account);
	}

	@Override
	public List<IAccount> getAccounts() {
		return accounts;
	}

	@Override
	public void removeAccount(IAccount account) {
		this.accounts.remove(account);
	}

	@Override
	public ICustomer getCustomerByAccount(String accountNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		INotifyFunctor functor = (INotifyFunctor) arg;
		functor.notifyCustomer();
	}

	@Override
	public IAccount getAccount() {
		return this.account;
	}

	public String getName() {
		return name;
	}

	public List<IAddress> getAddresses() {
		return addresses;
	}

	@Override
	public CustomerType getCustomerType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCustomerDetails() {
		String newLine = System.getProperty("line.separator");
		StringBuffer report = new StringBuffer();
		report.append("Name 	: " + getName() + newLine);
		report.append("Type 	: " + getType() + newLine);
		report.append("Address	: \n" + getAddressReport() + newLine);
		return report.toString();
	}

	private CustomerType getType() {
		return type;
	}

	private String getAddressReport() {
		StringBuffer report = new StringBuffer();
		for (IAddress adr : addresses) {
			report.append(adr.getFormattedAddress());
		}
		return report.toString();
	}

}
