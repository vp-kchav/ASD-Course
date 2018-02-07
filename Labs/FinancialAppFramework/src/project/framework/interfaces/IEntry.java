package project.framework.interfaces;

import java.util.Date;

import project.framework.EntryType;

public interface IEntry {
	double getAmount();
	Date getDate();
	EntryType getType();
}
