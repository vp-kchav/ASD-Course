package project.ccard;

import project.framework.*;
import project.framework.interfaces.IAccount;
import project.framework.interfaces.IAddress;
import project.framework.interfaces.ICustomer;
import project.framework.interfaces.IEntry;
import project.framework.interfaces.IPerson;
import java.text.ParseException;
import java.util.*;

/**
 * 
 * @author Ermias Kidane 
 * @Date   December 18, 2012
 * @Description: Manage Credit card operations and generating reports.	
 */
public abstract class CreditAccount extends Account {

	IAccount account;
	IAddress address;
	IPerson person;
	private String expDate;
	
	public CreditAccount(){}
	public CreditAccount(String accountNumber, Date expDate){
		super(accountNumber);
		this.expDate = expDate.toString();
	}
	
	public String getExpDate(){ return this.expDate;}
	@Override
	public void generateMonthlyBill() {
				
	}
	
	public abstract double getMonthlyInterest();
	public abstract double getMonthlyPayment();
	
	
	public double totalCredit(Date date){
		double _balance = 0d;
		
		Date startDate= DateManager.getFirstDayOfMonth(date);
		Date endDate= DateManager.getLastDayOfMonth(date);
		
		DateManager dManager = new DateManager(startDate, endDate);
		
		for(IEntry entry : getEntryHistory()){						
			if(entry.getType()==EntryType.DEPOSIT && dManager.isInRange(date))
				_balance += entry.getAmount();
		}
		return _balance;
	}
	
	public double totalCharges(Date date){
		double _balance = 0d;
		
		Date startDate= DateManager.getFirstDayOfMonth(date);
		Date endDate= DateManager.getLastDayOfMonth(date);
		
		DateManager dManager = new DateManager(startDate, endDate);
		
		for(IEntry entry : getEntryHistory()){			
			if(entry.getType()==EntryType.WITHDRAW && dManager.isInRange(date))
				_balance += entry.getAmount();
		}
		return _balance;
	}
	
	public double previousBalance(Date date){		
		return totalCredit(date);
	}

	public double netBalance(Date date) throws ParseException{
		return previousBalance(date) - totalCredit(date) + 
				totalCharges(date) + getMonthlyInterest() *
				(previousBalance(date)-totalCredit(date));
	}
	
	public double totalDue(Date date) throws ParseException{
		// getMonthlyPayment is implemented on the sub-classes (GOLD,BRONZE,SILVER)
		return getMonthlyPayment() * netBalance(date);
	}
	
	public static String generateReport(ICustomer customer){
		Date date = new Date();
		String newLine = "\r\n";
		StringBuilder stringBuilder = new StringBuilder();
		StringBuilder addressBuilder = new StringBuilder();
		StringBuilder accountBuilder = new StringBuilder();
		
		try {
		stringBuilder.append("Name: " + customer.getName() + newLine);
		stringBuilder.append("Address: " + newLine);
		for(IAddress address : customer.getAddresses()){
			addressBuilder.append(address.getStreet()+ "," + address.getCity() + " " +
					address.getState()+ "," + address.getZip() + newLine);
		}
		
		stringBuilder.append(addressBuilder);
		for(IAccount account : customer.getAccounts()){
			accountBuilder.append("----------------------------------------------------"+ newLine);
			accountBuilder.append("Account Type:" + getAccountType(account) + newLine);
			accountBuilder.append("Account Number: " + account.getAccountNumber() + newLine);
			
			accountBuilder.append("Previous Balance: " + ((CreditAccount)account).previousBalance(date) + newLine);
			
			accountBuilder.append("Total Credits: " + ((CreditAccount)account).totalCredit(date) + newLine);
			
			accountBuilder.append("Total Charges: " + ((CreditAccount)account).totalCharges(date) + newLine);
			accountBuilder.append("New Balance: " + ((CreditAccount)account).netBalance(date)  + newLine);
			accountBuilder.append("Total Amount due: " + ((CreditAccount)account).totalDue(date)+ newLine);
		}
		
		stringBuilder.append(accountBuilder);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return stringBuilder.toString();
	}
	
	public static String getAccountType(IAccount account){
		if(account instanceof Gold){
			return "Gold";
		}else if(account instanceof Silver){
			return "Silver";
		}else if(account instanceof Bronze){
			return "Bronze";
		}else return "Unknown";
	}
}
