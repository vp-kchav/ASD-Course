package project.bank;

import java.util.List;

import project.framework.interfaces.IEntry;

public interface IComputeFunctor {
	public void compute(List<IEntry> entryHistory);
	public double getValue() ;
}
