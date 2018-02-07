package project.framework;

import java.util.Date;

import project.framework.interfaces.IEntry;

public class Entry implements IEntry {

	// Private properties.
	private double _amount;
	private Date _entryDate;
	private EntryType _entryType;
	
	public Entry(double amount, EntryType entryType, Date entryDate){
		this._amount = amount;
		this._entryType = entryType;
		this._entryDate = entryDate;
	}
	// Override getters.
	@Override
	public double getAmount() {
		return this._amount;
	}

	@Override
	public Date getDate() {
		return this._entryDate;
	}

	@Override
	public EntryType getType() {
		return this._entryType;
	}
	@Override
	public String toString() {
		return "Entry [_amount=" + _amount + ", _entryDate=" + _entryDate
				+ ", _entryType=" + _entryType + "]";
	}
	
	

}
