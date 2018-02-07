package project.bank;

import java.util.Iterator;
import java.util.List;

import project.framework.EntryType;
import project.framework.interfaces.IEntry;

public class ComputeFunctor {
	double amount = 0.0;
	StringBuffer entryReport;
	String newLine = "\n";
	public ComputeFunctor(){
		amount = 0.0;
		entryReport = new StringBuffer();
		newLine = System.getProperty("line.separator");
	}
	public void compute(List<IEntry> entryHistory) {
		
		IEntry entry;
		Iterator<IEntry> iter = entryHistory.iterator();
		while(iter.hasNext()){
			entry = iter.next();
			if(entry.getType().equals(EntryType.DEPOSIT)){
				amount += entry.getAmount();
				entryReport.append(" Deposit  : "+ entry.getAmount() + "\tDate: " + entry.getDate() + newLine);
			}
			else{
				amount -= entry.getAmount();
				entryReport.append(" Withdraw : "+ entry.getAmount() + "\tDate: " + entry.getDate() + newLine);
			}
		}
	}

	public double getValue() {
		return amount;
	}
	
	public String getEntryReport(){
		return entryReport.toString();
	}

}
