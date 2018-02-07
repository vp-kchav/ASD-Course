package project.framework.interfaces;

import java.util.Map;
import java.util.Observer;

public interface IDataStore {

	void addCustomer(ICustomer newCustomer);

	IAccount getAccountByAccountNo(String clientName, String accnr);

	Observer getCustomerByAccount(String clientName);

	Map<String, ICustomer> getCustomers();

	ICustomer getCustomer(String customerName);

}
