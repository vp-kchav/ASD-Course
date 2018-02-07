package project.bank;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.logging.Logger;

import javax.swing.UIManager;
import project.bank.gui.BankFrame;
import project.framework.CustomerFactory;
import project.framework.DataStore;
import project.framework.Entry;
import project.framework.EntryType;
import project.framework.AccountRule;
import project.framework.interfaces.IAccount;
import project.framework.interfaces.IAddress;
import project.framework.interfaces.ICustomer;
import project.framework.interfaces.ICustomerFactory;
import project.framework.interfaces.IDataAccessObject;
import project.framework.interfaces.IDataStore;
import project.framework.interfaces.IFinCo;
import project.framework.interfaces.IRule;
import project.framework.persistence.DatabaseException;
/**
 * @author Elias
 * 
 */
public class Bank implements IFinCo{
	private static final Logger log = Logger
			.getLogger("BankApp.class.getName()");
	
	IDataStore dataStore = DataStore.INSTANCE;
	IAccount bankAccount = new BankAccount();
	IDataAccessObject  dboCustomer = new CustomerDAO();
	
	public enum Account_Type {
		CHECKING, SAVING
	}

	private Bank() {
	}

	private static Bank instance = new Bank();

	public static Bank getInstance() {
		if (instance == null)
			instance = new Bank();
		return instance;
	}
	/*****************************************************
	 * The entry point for this application. Sets the Look and Feel to the
	 * System Look and Feel. Creates a new JFrame1 and makes it visible.
	 *****************************************************/
	static public void main(String args[]) {
		try {
			// Add the following code if you want the Look and Feel
			// to be set to the Look and Feel of the native system.

			try {
				UIManager.setLookAndFeel(UIManager
						.getSystemLookAndFeelClassName());
			} catch (Exception e) {
			}

			// Create a new instance of our application's frame, and make it
			// visible.
			(new BankFrame()).setVisible(true);
		} catch (Throwable t) {
			t.printStackTrace();
			// Ensure the application exits with an error condition.
			System.exit(1);
		}
	}
	
	public void addPersonalAccount(String clientName, IAddress address,
			String accountnr, String accountType, String amount) {
		IBankAccountFactory factory = BankAccountFactory.getInstance();
		IAccount account = factory
				.createAccount(accountnr, accountType, amount);
		ICustomerFactory factoryCustomer = CustomerFactory.getInstance();
		ICustomer newCustomer = factoryCustomer.createCustomer(clientName, CustomerType.PERSONAL,
				address, account);
		dataStore.addCustomer(newCustomer);//put(accountnr, newCustomer);
		
		//Save to Database
		try {
			((CustomerDAO) dboCustomer).saveCustomer(newCustomer);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addCompanyAccount(String clientName, IAddress address,
			String accountnr, String accountType, String amount) {
		IBankAccountFactory factory = BankAccountFactory.getInstance();
		IAccount account = factory
				.createAccount(accountnr, accountType, amount);
		ICustomerFactory factoryCustomer = CustomerFactory.getInstance();
		ICustomer newCustomer = factoryCustomer.createCustomer(clientName, CustomerType.COMPANY,
				address, account);
		dataStore.addCustomer(newCustomer);
	}
	
	@Override
	public boolean addEntry(double newamount, EntryType type, Date date,
			String accnr, String clientName) {
		boolean success = false;
		IAccount account = dataStore.getAccountByAccountNo(clientName, accnr);//getAccount(accnr);
		if (account != null) {
			//Add observers
			((Observable) account).addObserver(dataStore.getCustomerByAccount(clientName));
			success = account.updateBalance(clientName, type, newamount);
			if(success){
				account.addEntry(new Entry(newamount, type, date));
			}				
		}
		return success;
	}
	
	

	public void addInterestToAllAccounts() {
		IAccount account = null;
		List<IAccount> accounts = null;
		ICustomer customer = null;
		Map<String, ICustomer> customers = dataStore.getCustomers();
		Iterator<String> custiter = customers.keySet().iterator();
		while (custiter.hasNext()) {
			String key = custiter.next();
			customer = customers.get(key);
			accounts = customer.getAccounts();
			Iterator<IAccount> iter = accounts.iterator();
			while (iter.hasNext()) {
				account = iter.next();
				account.addInterest();
			}
		}
		log.info("Interest added to all accounts");
	}

	public Map<String, ICustomer> getCustomers(){
		return dataStore.getCustomers();
	}

	public boolean runAccountRule(String clientName, String accountnr) {
		IRule rule = new AccountRule();
		return rule.canCreateAccount(clientName, accountnr);
	}

	public String generateReport(String customerName) {		
		StringBuilder stringBuilder = new StringBuilder();
		ICustomer customer = dataStore.getCustomers().get(customerName);
		stringBuilder.append(customer.getCustomerDetails());
		IAccount account;
		List<IAccount> accounts = customer.getAccounts();
		Iterator<IAccount> iter = accounts.iterator();
		while (iter.hasNext()) {
			account = iter.next();
			((BankAccount) account).setFuncor(new ComputeFunctor());
			account.generateMonthlyBill();
			stringBuilder.append(account.getMonthlyBillReport());
		}		
		return stringBuilder.toString();
	}
	public void addAccount(IAccount account2, String customerName){
		IBankAccountFactory factory = BankAccountFactory.getInstance();
		IAccount account = factory
				.createAccount(account2.get_accountNumber(), account2.getAccountType(), account2.getAmount()+"");
		ICustomer existingCustomer = dataStore.getCustomer(customerName);
		if(existingCustomer !=null){
			existingCustomer.addAccount(account);
			log.info("New account has been added to existing customer");
		}			
		else
			log.info("Unable to add new account to customer");
	}
	
}
