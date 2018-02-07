package project.ccard;

import java.util.*;

import project.framework.Account;
import project.framework.Address;
import project.framework.Customer;
import project.framework.Person;
import project.framework.interfaces.IAccount;
import project.framework.interfaces.IAddress;
import project.framework.interfaces.ICustomer;
import project.framework.interfaces.IPerson;
public enum CreditFactory implements ICreditFactory{
	INSTANCE;
	IPerson person;
	
	public CreditAccount getInstance(String type, String accountNumber, Date expDate){
		if(type.equals("Bronze"))
			return new Bronze(accountNumber, expDate);
		else if(type.equals("Silver"))
			return new Silver(accountNumber, expDate);
		else 
			return new Gold(accountNumber, expDate);
	}
	
	public ICustomer getPersonInstance(String name, IAddress address, IAccount account){
		return new Person(name, address, account);
	}
	
	public IAddress getAddressInstace(String street, String city, String state, String zipCode){
		return new Address(street, city, state, zipCode);
	}
	
	public ICustomer getCustomerInstance(){
		return new Customer();
	}
	
	public IAccount getAccountInstance(){
		return new Account();
	}

	@Override
	public IAccount createAccount() {
		// TODO Auto-generated method stub
		return null;
	}
}
