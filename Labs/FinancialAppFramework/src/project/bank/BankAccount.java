package project.bank;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import project.framework.Account;
import project.framework.DataStore;
import project.framework.EntryType;
import project.framework.interfaces.ICustomer;
import project.framework.interfaces.IEntry;

public class BankAccount extends Account {
	DataStore dataStore = DataStore.INSTANCE;
	private static final Logger log = Logger
			.getLogger("Account.class.getName()");

	StringBuffer report;
	private ComputeFunctor func;

	public BankAccount(String accountnr, String accountType,
			String amountDeposit) {
		super(accountnr, accountType, amountDeposit);
	}

	public BankAccount() {
		// TODO Auto-generated constructor stub
	}

	public boolean withdrawMoney(Double amount) {
		return false;

	}
	
//	public abstract void addInterest();

	@Override
	public boolean updateBalance(String name, EntryType type, Double newamount) {
		String notification = "";
		ICustomer customer = dataStore.getCustomerByAccount(name);

		if (type.equals(EntryType.DEPOSIT)) {
			this.amount += newamount;
			if (customer.getCustomerType().equals(CustomerType.COMPANY)) {
				notification = "NEW EMAIL: Deposit = $" + newamount
						+ " has been made to your Company Account on "
						+ new Date();
				emailCustomer(notification);
				return true;
			}
			if (customer.getCustomerType().equals(CustomerType.PERSONAL)) {
				if (newamount > 500) {
					notification = "NEW EMAIL: Deposit = $" + newamount
							+ " has been made to your Personal Account on "
							+ new Date();
					emailCustomer(notification);
					return true;
				}
			}

			log.info("Deposit commited");
		} else if (type.equals(EntryType.WITHDRAW)) {
			if (customer.getCustomerType().equals(CustomerType.COMPANY)) {
				if (amount < newamount) {
					notification = "NEW EMAIL: You don't have sufficient balance to make Withdrawal = $"
							+ newamount
							+ " on your Company Account on "
							+ new Date();
					emailCustomer(notification);
					return false;
				}
				notification = "NEW EMAIL: Withdrawal = $" + newamount
						+ " has been made on your Company Account on "
						+ new Date();
				emailCustomer(notification);
			}
			if (customer.getCustomerType().equals(CustomerType.PERSONAL)) {
				if (amount < newamount) {
					notification = "NEW EMAIL: You don't have sufficient balance to make Withdrawal = $"
							+ newamount
							+ " on your Personal Account on "
							+ new Date();
					emailCustomer(notification);
					return false;
				}
				if (newamount > 500) {
					notification = "NEW EMAIL: Withdrawal = $" + newamount
							+ " has been made on your Personal Account on "
							+ new Date();
					emailCustomer(notification);
				}				
			}
			log.info("Withdrawal commited");
		}
		return true;
	}

	private void emailCustomer(String notification) {
		notifyEmailSending(new NotifyCustomerFunctor(notification));
	}

	public void setFuncor(ComputeFunctor func) {
		this.func = func;
	}

	public double getCurrentBalance() {
		// Use a functor to calculate total balance from the entry history.
		List<IEntry> entries = getEntryHistory();
		func.compute(entries);
		double currentbalance = func.getValue();
		return currentbalance;
	}

	@Override
	public void generateMonthlyBill() {
		String newLine = System.getProperty("line.separator");
		report = new StringBuffer();
		report.append("Account Number : " + get_accountNumber() + newLine);
		report.append("Account Type	: " + getAccountType() + newLine);
		report.append("Current Balance: " + getCurrentBalance() + newLine);
		report.append("Transaction History: \n" + func.getEntryReport()
				+ newLine);
		report.append(newLine);
	}

	@Override
	public String getMonthlyBillReport() {
		// TODO Auto-generated method stub
		return report.toString();
	}
}
