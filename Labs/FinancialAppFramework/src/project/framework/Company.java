package project.framework;


import java.util.Observable;
import java.util.Observer;
import java.util.logging.Logger;

import project.bank.CustomerType;
import project.framework.interfaces.IAccount;
import project.framework.interfaces.IAddress;
import project.framework.interfaces.ICompany;
import project.framework.interfaces.INotifyFunctor;

public class Company extends Customer implements ICompany, Observer {
	private static final Logger log = Logger
			.getLogger("Company.class.getName()");
	
	private final static CustomerType CUSTOMER_TYPE = CustomerType.COMPANY; 
//	private int noEmployee; 
	public Company(String name, CustomerType type, IAddress address, IAccount account) {
		super(name, type, address, account);
	}
	
	public CustomerType getCustomerType() {
		return CUSTOMER_TYPE;
	}
	@Override
	public void update(Observable o, Object arg) {
//		super.update(o, arg);
		log.info("Email has been sent to the person about the transaction: \n\t" + ((INotifyFunctor)arg).getNotification());
	}
}
