package project.ccard;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.UIManager;

import project.ccard.gui.CardFrm;
import project.framework.Account;
import project.framework.DataStore;
import project.framework.Entry;
import project.framework.EntryType;
import project.framework.interfaces.IAccount;
import project.framework.interfaces.IAddress;
import project.framework.interfaces.ICustomer;
import project.framework.interfaces.IEntry;
import project.framework.interfaces.IFinCo;
import project.framework.interfaces.INotifyFunctor;
import project.framework.interfaces.IRule;

public enum Credit implements IFinCo{
	INSTANCE;

	DataStore dataStore = DataStore.INSTANCE;
	CreditFactory creditFactory = CreditFactory.INSTANCE;
	IAccount account;
	ICustomer customer;
	IEntry entry;
	Map<String, ICustomer> customers = new HashMap<>();

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
			(new CardFrm()).setVisible(true);
		} catch (Throwable t) {
			t.printStackTrace();
			// Ensure the application exits with an error condition.
			System.exit(1);
		}
	}
	
	public void addPersonalCreditAccount(ICustomer customer, IAccount account) {
		dataStore.addCustomer(customer);
	}

	public void addPersonalCreditAccount(String name, IAccount account,
			IAddress address) {
		
		customer = creditFactory.getPersonInstance(name, address, account);
		dataStore.addCustomer(customer);
	}

	public boolean addEntry(double amount, EntryType type, Date date,
			String accountNo, String customerName) {

		// Create account and customer object from the data store.
		account = dataStore.getAccountByAccountNo(customerName, accountNo);
		customer = dataStore.getCustomer(customerName);

		// if the operation is charge.
		if (type.equals(EntryType.WITHDRAW)) {
			// Add customer as observer of account.
			((Account) account).addObserver(customer);

			// Create charge testing predicate.
			IRule withdrawPredicate = new CreditRule();
			INotifyFunctor customerNotification = new CreditCustomerNotification();

			entry = new Entry(amount, type, date);
			account.addEntry(entry, withdrawPredicate, customerNotification);

		} else { // if the operation is deposit.
			entry = new Entry(amount, type, date);
			account.addEntry(entry);
		}
		return false;

	}

	public String generateReport(String customerName) {
		StringBuilder stringBuilder = new StringBuilder();
		customer = dataStore.getCustomers().get(customerName);

		stringBuilder.append(CreditAccount.generateReport(customer));
		return stringBuilder.toString();
	}

	public List<ICustomer> getCustomers() {
		Map<String, ICustomer> customers = dataStore.getCustomers();
		List<ICustomer> customers2 = new ArrayList<>();
		ICustomer objCustomer;
		for (Iterator<ICustomer> it = customers.values().iterator(); it
				.hasNext();) {
			objCustomer = it.next();
			customers2.add(objCustomer);
		}
		return customers2;
	}

	public ICustomer getCustomer(String customerName) {
		return dataStore.getCustomer(customerName);
	}
	
	public boolean isAccountExist(String customerName, String accountNo){
		IAccount account = dataStore.getAccountByAccountNo(customerName, accountNo);
		return account == null ? false : true;
	}
	public void addAccount(IAccount account, String customerName) {
		dataStore.addAccount(account, customerName);
	}

	@Override
	public void addPersonalAccount(String clientName, IAddress address,
			String accountnr, String accountType, String amount) {
		// TODO Auto-generated method stub
		
	}

}
