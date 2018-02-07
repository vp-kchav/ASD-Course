package project.ccard.gui;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;

import project.ccard.Bronze;
import project.ccard.CreditAccount;
import project.ccard.Gold;
import project.ccard.Silver;
import project.framework.gui.MainFrame;
import project.framework.interfaces.IAccount;
import project.framework.interfaces.ICustomer;

/**
 * A basic JFC based application.
 */
public class CardFrm extends MainFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/****
	 * init variables in the object
	 ****/
	String clientName, street, city, zip, state, accountType, amountDeposit,
			expdate, ccnumber;
	boolean newaccount;
	private DefaultTableModel model;
	CardFrm thisframe;
	@SuppressWarnings("unused")
	private Object rowdata[];

	public CardFrm() {
		super("Credit-card processing Application");
		thisframe = this;

		constructorGrid();
//		model = new DefaultTableModel();
//		model.addColumn("Name");
//		model.addColumn("CC number");
//		model.addColumn("Exp date");
//		model.addColumn("Type");
//		model.addColumn("Balance");
//		rowdata = new Object[7];
//		newaccount = false;
//
//		setTableModel(model);

		ArrayList<JButton> buttons = new ArrayList<JButton>();

		//
		//
		// JPanel1.add(JScrollPane1);
		// JScrollPane1.setBounds(12,92,444,160);
		// JScrollPane1.getViewport().add(JTable1);
		// JTable1.setBounds(0, 0, 420, 0);
		// // rowdata = new Object[8];
		//
		JButton_NewCCAccount.setText("Add New Customer");
		buttons.add(JButton_NewCCAccount);
		JButton_NewCCAccount.setBounds(24, 20, 192, 33);
		JButton_GenBill.setText("Generate Monthly bills");
		JButton_GenBill.setActionCommand("jbutton");
		buttons.add(JButton_GenBill);
		JButton_GenBill.setBounds(240, 20, 192, 33);

		JButton_AddAccount.setText("Add Account");
		buttons.add(JButton_AddAccount);
		JButton_AddAccount.setBounds(440, 20, 100, 33);

		JButton_Deposit.setText("Deposit");
		buttons.add(JButton_Deposit);
		JButton_Deposit.setBounds(468, 104, 96, 33);
		JButton_Withdraw.setText("Charge");
		buttons.add(JButton_Withdraw);
		JButton_Withdraw.setBounds(468, 164, 96, 33);

		setPanel1Content(buttons);
		JButton_GenBill.setActionCommand("jbutton");

		SymAction lSymAction = new SymAction();
		JButton_NewCCAccount.addActionListener(lSymAction);
		JButton_GenBill.addActionListener(lSymAction);
		JButton_Deposit.addActionListener(lSymAction);
		JButton_Withdraw.addActionListener(lSymAction);
		JButton_AddAccount.addActionListener(lSymAction);

	}
	
	

	javax.swing.JButton JButton_NewCCAccount = new javax.swing.JButton();
	javax.swing.JButton JButton_GenBill = new javax.swing.JButton();
	javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
	javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();
	javax.swing.JButton JButton_AddAccount = new javax.swing.JButton();

	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_NewCCAccount)
				JButtonNewCCAC_actionPerformed(event);
			else if (object == JButton_GenBill)
				JButtonGenerateBill_actionPerformed(event);
			else if (object == JButton_Deposit)
				JButtonDeposit_actionPerformed(event);
			else if (object == JButton_Withdraw)
				JButtonWithdraw_actionPerformed(event);
			else if (object == JButton_AddAccount)
				JButtonAddAccount_actionPerformed(event);

		}
	}

	protected void constructorGrid(){
		model = new DefaultTableModel();
		model.addColumn("Name");
		model.addColumn("CC number");
		model.addColumn("Type");
		model.addColumn("Exp Date");
		model.addColumn("Balance");
		setTableModel(model);
	}
	
	@SuppressWarnings("deprecation")
	void JButtonNewCCAC_actionPerformed(java.awt.event.ActionEvent event) {
		/*
		 * JDialog_AddPAcc type object is for adding personal information
		 * construct a JDialog_AddPAcc type object set the boundaries and show
		 * it
		 */

		JDialog_AddCCAccount ccac = new JDialog_AddCCAccount(thisframe, true,
				"");
		ccac.setBounds(450, 20, 300, 380);
		ccac.show();
	}

	@SuppressWarnings("deprecation")
	public void JButtonAddAccount_actionPerformed(ActionEvent event) {
		int selection = getJTable1().getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String name = (String) model.getValueAt(selection, 0);
			JDialog_AddCCAccount ccac = new JDialog_AddCCAccount(thisframe,
					false, name);
			ccac.setBounds(450, 20, 300, 380);
			ccac.show();
		}
	}

	private String getAccountType(IAccount account) {
		if (account instanceof Gold)
			return "Gold";
		else if (account instanceof Silver)
			return "Silver";
		else if (account instanceof Bronze)
			return "Bronze";
		else
			return "Unknown";
	}

	public void LoadListData(List<ICustomer> customers) {
		//model = new DefaultTableModel();
		constructorGrid();
		
		
		//setTableModel(new DefaultTableModel());
		
		
		Vector<String> v = new Vector<>();
		for (ICustomer customer : customers) {
			for (IAccount account : customer.getAccounts()) {
				v = new Vector<>();
				v.add(customer.getName()); //0
				v.add(account.getAccountNumber()); // 1
				v.add(getAccountType(account)); // 2
				v.add(((CreditAccount) account).getExpDate()); // 3
				v.add(String.valueOf(account.getCurrentBalance())); // 4
				model.addRow(v);
			}
		}
		setTableModel(model);
		getJTable1().getSelectionModel().setAnchorSelectionIndex(-1);
	}

	@SuppressWarnings("deprecation")
	void JButtonGenerateBill_actionPerformed(java.awt.event.ActionEvent event) {
		int selection = getJTable1().getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String name = (String) model.getValueAt(selection, 0);
			JDialogGenBill billFrm = new JDialogGenBill(this, name);
			billFrm.setBounds(450, 20, 400, 350);
			billFrm.show();
		}

	}

	@SuppressWarnings("deprecation")
	void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event) {
		// get selected name
		int selection = getJTable1().getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String name = (String) model.getValueAt(selection, 0);
			String ccNumber = (String) model.getValueAt(selection, 1);

			System.out.println("CC Number: " + ccNumber);

			// Show the dialog for adding deposit amount for the current mane
			JDialog_Deposit dep = new JDialog_Deposit(thisframe, name, ccNumber);
			dep.setBounds(430, 15, 275, 140);
			dep.show();

			// compute new amount
//			long deposit = Long.parseLong(amountDeposit);
//			String samount = (String) model.getValueAt(selection, 4);
//			long currentamount = Long.parseLong(samount);
//			long newamount = currentamount + deposit;
//			model.setValueAt(String.valueOf(newamount), selection, 4);
		}

	}

	@SuppressWarnings("deprecation")
	void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event) {
		// get selected name
		int selection = getJTable1().getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String name = (String) model.getValueAt(selection, 0);
			String accountNo = (String) model.getValueAt(selection, 1);

			// Show the dialog for adding withdraw amount for the current mane
			JDialog_Withdraw wd = new JDialog_Withdraw(thisframe, name,
					accountNo);
			wd.setBounds(430, 15, 275, 140);
			wd.show();

//			// compute new amount
//			long deposit = Long.parseLong(amountDeposit);
//			String samount = (String) model.getValueAt(selection, 4);
//			long currentamount = Long.parseLong(samount);
//			long newamount = currentamount - deposit;
//			model.setValueAt(String.valueOf(newamount), selection, 4);
//			if (newamount < 0) {
//				JOptionPane.showMessageDialog(
//						JButton_Withdraw,
//						" " + name + " Your balance is negative: $"
//								+ String.valueOf(newamount) + " !",
//						"Warning: negative balance",
//						JOptionPane.WARNING_MESSAGE);
//			}
		}

	}

}
