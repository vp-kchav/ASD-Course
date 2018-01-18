package mum.asd.factorymethod;

public class Consoller extends AbstractTrace implements Trace {
	
	@Override
	public void debug(String message) {
		if(isDebug()) {
			System.out.println("Debug - " + getCurrentDatetime() + " - " + message);
		}
	}
	
	@Override
	public void setDebug(boolean debug) {
		isDebug(debug);
	}

	@Override
	public void error(String message) {
		System.out.println("ERROR - " + getCurrentDatetime() + " - " + message);
	}

	public void myConsoller() {
		
	}
}
