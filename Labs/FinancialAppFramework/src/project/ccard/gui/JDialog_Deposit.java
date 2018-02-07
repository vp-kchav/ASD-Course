package project.ccard.gui;

import java.util.Date;

import javax.swing.*;

import project.ccard.Credit;
import project.framework.EntryType;
import project.framework.gui.EntryDialog;

public class JDialog_Deposit extends EntryDialog
{
	private static final long serialVersionUID = 1L;
	Credit creditApp = Credit.INSTANCE;
	String accountNo="";
	String customerName;
	
	public JDialog_Deposit(JFrame parent, String aname, String accountNo)
	{
		super(parent, aname, "Deposit");
		this.customerName = aname;
		System.out.println(accountNo);
		this.accountNo = accountNo;
	}

	public void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
	{
       ((CardFrm)this.getParentframe()).amountDeposit = this.getJTextField_Amount().getText();
		
		creditApp.addEntry(Double.parseDouble(this.getJTextField_Amount().getText()), EntryType.DEPOSIT, new Date(), this.accountNo, this.customerName);
		((CardFrm)this.getParentframe()).LoadListData(creditApp.getCustomers());
        dispose();
	}
}