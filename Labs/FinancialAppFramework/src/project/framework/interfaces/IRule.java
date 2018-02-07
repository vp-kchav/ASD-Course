package project.framework.interfaces;


public interface IRule {
	boolean canAdd(IEntry entry, double balance);
	boolean canCreateAccount(String clientName, String accountNumber);
}
