package mum.asd.factorymethod;

public class TraceFactory implements ITraceFactory {

	private static TraceFactory INSTANCE;
	private final String LOG = "trace.log";
	private final String CONSOLE = "console";
	
	private TraceFactory() {

	}
	
	public static synchronized TraceFactory getInstance() {
		if(INSTANCE == null) 
			INSTANCE = new TraceFactory();
		return INSTANCE;
	}
	
	@Override
	public Trace getTrace(String type) {
		if(type.equalsIgnoreCase(LOG)) {
			return new Logger();
		}else if(type.equalsIgnoreCase(CONSOLE)) {
			return new Consoller();
		}
		return null;
	}

	
}
