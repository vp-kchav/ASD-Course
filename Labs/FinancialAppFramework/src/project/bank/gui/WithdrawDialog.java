package project.bank.gui;
import project.framework.gui.EntryDialog;

public class WithdrawDialog extends EntryDialog
{
	private static final long serialVersionUID = 1L;
	private BankFrame parentframe;

	public WithdrawDialog(BankFrame parent, String name)
	{
		super(parent,name, "Withdraw");
		this.parentframe=  parent;
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