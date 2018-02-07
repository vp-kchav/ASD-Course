package project.framework;

import project.bank.CustomerType;
import project.framework.interfaces.IAccount;
import project.framework.interfaces.IAddress;
import project.framework.interfaces.ICustomer;
import project.framework.interfaces.ICustomerFactory;

public class CustomerFactory implements ICustomerFactory { 
	
	private CustomerFactory() {
	}

	private static CustomerFactory instance = new CustomerFactory();

	public static CustomerFactory getInstance() {
		if (instance == null)
			instance = new CustomerFactory();
		return instance;
	}

	private static CustomerType readCustomerType(CustomerType customerType) {
		if (CustomerType.PERSONAL.equals(customerType))
			return CustomerType.PERSONAL;
		else
			return CustomerType.COMPANY;
	}

	@Override
	public ICustomer createCustomer(String clientName, CustomerType customerType,
			IAddress address, IAccount account) {
		CustomerType cust = readCustomerType(customerType);
		switch (cust) {
		case PERSONAL:
			return new  Person(clientName, customerType, address, account);
		default:
			return new  Company(clientName, customerType, address, account);
		}
	}
}
