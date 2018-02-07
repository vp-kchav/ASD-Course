package project.ccard.gui;

import java.util.Date;
import javax.swing.*;

import project.ccard.Credit;
import project.framework.EntryType;
import project.framework.gui.EntryDialog;

public class JDialog_Withdraw extends EntryDialog {
	private static final long serialVersionUID = 1L;
	Credit creditApp = Credit.INSTANCE;
	String accountNo = "";
	String customerName;

	public JDialog_Withdraw(JFrame parent, String aname, String accountNo) {
		super(parent, aname, "Withdraw");
		this.customerName = aname;
		this.accountNo = accountNo;
	}

	public void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		((CardFrm) this.getParentframe()).amountDeposit = this
				.getJTextField_Amount().getText();
		creditApp.addEntry(
				Double.parseDouble(this.getJTextField_Amount().getText()),
				EntryType.WITHDRAW, new Date(), this.accountNo,
				this.customerName);

		// Update the list.
		((CardFrm) this.getParentframe())
				.LoadListData(creditApp.getCustomers());
		dispose();
	}

	public void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event) {
		dispose();
	}
}