package project.framework;

import java.util.Date;

import javax.swing.UIManager;

import project.framework.gui.MainFrame;
import project.framework.interfaces.IAccount;
import project.framework.interfaces.IAddress;
import project.framework.interfaces.IFinCo;

public class FinCo implements IFinCo{

	/*****************************************************
	 * The entry point for this application.
	 * Sets the Look and Feel to the System Look and Feel.
	 * Creates a new JFrame1 and makes it visible.
	 *****************************************************/
	static public void main(String args[])
	{
		try {
		    // Add the following code if you want the Look and Feel
		    // to be set to the Look and Feel of the native system.
		    
		    try {
		        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    } 
		    catch (Exception e) { 
		    }
			//Create a new instance of our application's frame, and make it visible.
		    MainFrame mainframe = new MainFrame("Framework Application");
		    mainframe.initialize();
		    mainframe.setVisible(true);
		    
		} 
		catch (Throwable t) {
			t.printStackTrace();
			//Ensure the application exits with an error condition.
			System.exit(1);
		}
	}

	@Override
	public void addPersonalAccount(String clientName, IAddress address,
			String accountnr, String accountType, String amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addEntry(double amount, EntryType type, Date date,
			String accountNo, String customerName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String generateReport(String customerName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAccount(IAccount account2, String customerName) {
		// TODO Auto-generated method stub
		
	}


}
