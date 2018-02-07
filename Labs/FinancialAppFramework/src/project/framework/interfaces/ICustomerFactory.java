package project.framework.interfaces;

import project.bank.CustomerType;

public interface ICustomerFactory {

	ICustomer createCustomer(String clientName, CustomerType type, IAddress address,
			IAccount account);

}
