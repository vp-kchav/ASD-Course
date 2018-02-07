package project.bank.gui;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;

import project.bank.Bank;
import project.bank.CustomerType;
import project.framework.Account;
import project.framework.Address;
import project.framework.EntryType;
import project.framework.gui.MainFrame;
import project.framework.interfaces.IAccount;
import project.framework.interfaces.IAddress;
import project.framework.interfaces.ICustomer;

/**
 * A basic JFC based application.
 * @description 
 */
public class BankFrame extends MainFrame {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger
			.getLogger("BankFrm.class.getName()");
	/****
	 * init variables in the object
	 ****/
	String accountnr, clientName, street, city, zip, state, accountType,
			clientType, email;
	public String amount;
	boolean newaccount;
	private DefaultTableModel model;
	BankFrame myframe;
	private Object rowdata[];

	Bank bankApplication = Bank.getInstance();

	public BankFrame() {

		super("Bank Application");
		myframe = this;
		rowdata = new Object[8];
		setTableModel(getNewModel());

		ArrayList<JButton> buttons = new ArrayList<JButton>();

		JButton_PerAC.setText("Add personal account");
		buttons.add(JButton_PerAC);
		JButton_PerAC.setBounds(20, 20, 150, 33);
		JButton_CompAC.setText("Add company account");
		JButton_CompAC.setActionCommand("jbutton");
		buttons.add(JButton_CompAC);
		JButton_CompAC.setBounds(220, 20, 150, 33);

		JButton_GenBill.setText("Generate Report");
		JButton_GenBill.setActionCommand("jbutton");
		buttons.add(JButton_GenBill);
		JButton_GenBill.setBounds(420, 20, 150, 33);

		JButton_AddAccount.setText("Add Account");
		buttons.add(JButton_AddAccount);
		JButton_AddAccount.setBounds(468, 90, 96, 33);

		JButton_Addinterest.setBounds(468, 130, 96, 33);
		JButton_Addinterest.setText("Add interest");
		buttons.add(JButton_Addinterest);

		JButton_Deposit.setText("Deposit");
		buttons.add(JButton_Deposit);
		JButton_Deposit.setBounds(468, 170, 96, 33);

		JButton_Withdraw.setText("Withdraw");
		buttons.add(JButton_Withdraw);

		JButton_Withdraw.setBounds(468, 210, 96, 33);
		JButton_Exit.setText("Exit");
		buttons.add(JButton_Exit);
		JButton_Exit.setBounds(468, 250, 96, 31);

		JButton_PerAC.setActionCommand("jbutton");

		SymAction lSymAction = new SymAction();
		JButton_PerAC.addActionListener(lSymAction);
		JButton_CompAC.addActionListener(lSymAction);
		JButton_GenBill.addActionListener(lSymAction);
		JButton_Deposit.addActionListener(lSymAction);
		JButton_Withdraw.addActionListener(lSymAction);
		JButton_Addinterest.addActionListener(lSymAction);
		JButton_AddAccount.addActionListener(lSymAction);
		setPanel1Content(buttons);

	}

	private DefaultTableModel getNewModel() {
		model = new DefaultTableModel();
		model.addColumn("AccountNr");
		model.addColumn("Name");
		model.addColumn("City");
		model.addColumn("P/C");
		model.addColumn("Ch/S");
		model.addColumn("Amount");
		return model;
	}

	

	javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
	javax.swing.JButton JButton_PerAC = new javax.swing.JButton();
	javax.swing.JButton JButton_CompAC = new javax.swing.JButton();
	javax.swing.JButton JButton_GenBill = new javax.swing.JButton();
	javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
	javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();
	javax.swing.JButton JButton_Addinterest = new javax.swing.JButton();
	javax.swing.JButton JButton_AddAccount = new javax.swing.JButton();
	javax.swing.JButton JButton_Exit = new javax.swing.JButton();
	public boolean okAddAccountClicked = false;

	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_PerAC)
				JButtonPerAC_actionPerformed(event);
			else if (object == JButton_CompAC)
				JButtonCompAC_actionPerformed(event);
			else if (object == JButton_GenBill)
				JButtonGenerateBill_actionPerformed(event);
			else if (object == JButton_Deposit)
				JButtonDeposit_actionPerformed(event);
			else if (object == JButton_Withdraw)
				JButtonWithdraw_actionPerformed(event);
			else if (object == JButton_Addinterest)
				JButtonAddinterest_actionPerformed(event);
			else if (object == JButton_AddAccount)
				JButtonAddAccount_actionPerformed(event);
		}

	}

	public void JButtonAddAccount_actionPerformed(ActionEvent event) {
		int selection = getJTable1().getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String title = "Add Account for Customer";
			String name = (String) model.getValueAt(selection, 1);
			ICustomer customer = bankApplication.getCustomers().get(name);
			if(customer==null)
				return;
			if(customer.getCustomerType().equals(CustomerType.PERSONAL)){
				AddPersAccDialog dialog = new AddPersAccDialog(this, title, customer);
				dialog.setBounds(450, 20, 300, 330);
				dialog.show();
			}				
			else if(customer.getCustomerType().equals(CustomerType.COMPANY)){
				AddCompAccDialog dialog = new AddCompAccDialog(this, title, customer);
				dialog.setBounds(450, 20, 300, 330);
				dialog.show();
			}
//			dialog.setBounds(450, 20, 300, 380);
			

			if (okAddAccountClicked) {
				boolean cont = bankApplication.runAccountRule(clientName,
						accountnr);
				if (!cont) {
					JOptionPane.showMessageDialog(null,
							"Account number already exists");
					return;
				}
				amount = "0";
				IAccount account2 = new Account(accountnr, accountType, amount);
				bankApplication.addAccount(account2, clientName);
				log.info("Adding account to existing customer...");
				refreshModel();
				okAddAccountClicked = false;
			}

		}
	}

	void JButtonGenerateBill_actionPerformed(ActionEvent event) {
		int selection = getJTable1().getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String name = (String) model.getValueAt(selection, 1);
			String report = bankApplication.generateReport(name);
			ReportDialog billFrm = new ReportDialog(this, report);
			billFrm.setBounds(450, 20, 400, 350);
			billFrm.show();
		}
	}

	void JButtonPerAC_actionPerformed(java.awt.event.ActionEvent event) {
		/*
		 * JDialog_AddPAcc type object is for adding personal information
		 * construct a JDialog_AddPAcc type object set the boundaries and show
		 * it
		 */

		String title = "Add New Personal Account";
		AddPersAccDialog pac = new AddPersAccDialog(myframe, title, null);
		pac.setBounds(450, 20, 300, 330);
		pac.show();

		if (okAddAccountClicked) {
			boolean cont = bankApplication
					.runAccountRule(clientName, accountnr);
			if (!cont) {
				JOptionPane.showMessageDialog(null,
						"Account number already exists");
				return;
			}
			amount = "0";
			IAddress address = new Address(street, city, state, zip, email);
			bankApplication.addPersonalAccount(clientName, address, accountnr,
					accountType, amount);

			log.info("Adding new account ...");
			refreshModel();
			okAddAccountClicked = false;

		}

	}

	private void refreshModel() {
		model = getNewModel();
		updateModel();
	}

	private void updateModel() {
		ICustomer customer;
		IAccount account;
		List<IAccount> accounts;
		Iterator<IAccount> accountIterator;
		Map<String, ICustomer> customers = bankApplication.getCustomers();
		Iterator<String> customerIterator = customers.keySet().iterator();
		while (customerIterator.hasNext()) {
			String key = customerIterator.next();
			customer = customers.get(key);
			rowdata[1] = customer.getName();
			rowdata[2] = customer.getAddresses().get(0).getCity();
			rowdata[3] = customer.getCustomerType();
			accounts = customer.getAccounts();
			accountIterator = accounts.iterator();
			while (accountIterator.hasNext()) {
				account = accountIterator.next();
				rowdata[0] = account.get_accountNumber();
				rowdata[4] = account.getAccountType();
				rowdata[5] = account.getAmount().toString();
				model.addRow(rowdata);
			}
		}
		setTableModel(model);
		getJTable1().getSelectionModel().setAnchorSelectionIndex(-1);
	}

	void JButtonCompAC_actionPerformed(java.awt.event.ActionEvent event) {
		/*
		 * construct a JDialog_AddCompAcc type object set the boundaries and
		 * show it
		 */
		String title = "Add New Personal Account";
		AddCompAccDialog pac = new AddCompAccDialog(myframe, title, null);
		pac.setBounds(450, 20, 300, 330);
		pac.show();

		if (okAddAccountClicked) {
			boolean cont = bankApplication
					.runAccountRule(clientName, accountnr);
			if (!cont) {
				JOptionPane.showMessageDialog(null,
						"Account number already exists");
				return;
			}
			amount = "0";
			IAddress address = new Address(street, city, state, zip, email);
			bankApplication.addCompanyAccount(clientName, address, accountnr,
					accountType, amount);
			refreshModel();
			okAddAccountClicked = false;

		}
	}

	void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event) {
		// get selected name
		int selection = getJTable1().getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String accnr = (String) model.getValueAt(selection, 0);

			// Show the dialog for adding deposit amount for the current mane
			DepositDialog dep = new DepositDialog(myframe, accnr);
			dep.setBounds(430, 15, 275, 140);
			dep.show();

			// compute new amount
			Double deposit = Double.parseDouble(amount);
			String samount = (String) model.getValueAt(selection, 5);
			Double currentamount = Double.parseDouble(samount);
			Double newamount = currentamount + deposit;
		
			boolean success = bankApplication.addEntry(deposit,  EntryType.DEPOSIT, new Date(),  accnr,clientName);

			if (success) {
				// refreshModel();
				model.setValueAt(String.valueOf(newamount), selection, 5);
				JOptionPane.showMessageDialog(null, "Deposited");
			} else {
				JOptionPane.showMessageDialog(null, "Unable to deposit amount");
			}

		}

	}

	void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event) {
		// get selected name
		int selection = getJTable1().getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String accnr = (String) model.getValueAt(selection, 0);

			// Show the dialog for adding withdraw amount for the current mane
			WithdrawDialog wd = new WithdrawDialog(myframe, accnr);
			wd.setBounds(430, 15, 275, 140);
			wd.show();

			// compute new amount
			Double withdrawAmount = Double.parseDouble(amount);
			String samount = (String) model.getValueAt(selection, 5);
			Double currentamount = Double.parseDouble(samount);
			Double newamount = currentamount - withdrawAmount;


			boolean success = bankApplication.addEntry(withdrawAmount, EntryType.WITHDRAW, new Date(),  accnr,clientName);

			if (success) {
				// refreshModel();
				model.setValueAt(String.valueOf(newamount), selection, 5);
				JOptionPane.showMessageDialog(null, "Withdrawn");
			} else {
				JOptionPane
						.showMessageDialog(null, "Unable to withdraw amount");
			}
			if (newamount < 0) {
				JOptionPane.showMessageDialog(JButton_Withdraw,
						" Account " + accnr + " : balance is negative: $"
								+ String.valueOf(newamount) + " !",
						"Warning: negative balance",
						JOptionPane.WARNING_MESSAGE);
			}
		}

	}

	void JButtonAddinterest_actionPerformed(java.awt.event.ActionEvent event) {
		bankApplication.addInterestToAllAccounts();
		refreshModel();
		JOptionPane.showMessageDialog(JButton_Addinterest,
				"Interest has been added to all accounts");

	}
}
