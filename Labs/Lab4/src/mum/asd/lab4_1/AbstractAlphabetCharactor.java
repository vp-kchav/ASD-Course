package mum.asd.lab4_1;

public abstract class AbstractAlphabetCharactor {

	 public final void printCharactor() {
		String symmetrytype = getSymmetryType();
		String alphabet = getAlphabet();
		printOut(symmetrytype, alphabet);
	}
	
	public abstract String getAlphabet();
	public abstract String getSymmetryType();
	public abstract void printOut(String type, String alphabet);
	
}
