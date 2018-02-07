package project.bank;

import project.framework.interfaces.INotifyFunctor;

public class NotifyCustomerFunctor implements INotifyFunctor {

	private String notification;

	public NotifyCustomerFunctor(String notification) {
		this.notification = notification;
	}

	@Override
	public void notifyCustomer() {
		
	}

	public String getNotification() {
		return notification;
	}

	@Override
	public void notifyOutOfBalance() {
		// TODO Auto-generated method stub
		
	}
	

}
