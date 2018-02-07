
package project.framework.interfaces;

import java.util.List;
import java.util.Observer;

import project.bank.CustomerType;


public interface ICustomer extends Observer {
	public void addAccount(IAccount account);
	public List<IAccount> getAccounts();
	public void removeAccount(IAccount account);
	
	public ICustomer getCustomerByAccount(String accountNo);
	public IAccount getAccount();
	public String getName();
	public List<IAddress> getAddresses() ;
	public CustomerType getCustomerType();
	public String getCustomerDetails();
}
