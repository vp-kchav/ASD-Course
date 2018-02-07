package project.bank.gui;

import javax.swing.*;

import project.framework.gui.EntryDialog;

public class DepositDialog extends EntryDialog
{ 
	private static final long serialVersionUID = 1L;
	private BankFrame parentframe;

	public DepositDialog(BankFrame parent, String name)
	{
		super(parent, name, "Deposit");
		this.parentframe = parent;
	}

	public void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
	{
        parentframe.amount= getJTextField_Amount().getText();
        dispose();
	}

	public void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event)
	{
		dispose();
	}

}