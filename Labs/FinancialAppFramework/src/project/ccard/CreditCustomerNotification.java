package project.ccard;

import javax.swing.JOptionPane;

import project.framework.interfaces.INotifyFunctor;

public class CreditCustomerNotification implements INotifyFunctor {

	@Override
	public void notifyCustomer() {
		// dialog_Withdraw.showWarningMessage("Customer Credit has been Charged more than $400");
		JOptionPane.showMessageDialog(null,
				"Customer Credit has been Charged more than $400", "Warning",
				JOptionPane.WARNING_MESSAGE);
	}

	@Override
	public void notifyOutOfBalance() {
		JOptionPane.showMessageDialog(null, "Your balance is negative",
				"Warning: negative balance", JOptionPane.WARNING_MESSAGE);
	}

	@Override
	public String getNotification() {
		// TODO Auto-generated method stub
		return null;
	}

}
