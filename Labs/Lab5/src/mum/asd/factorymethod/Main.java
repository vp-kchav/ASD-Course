package mum.asd.factorymethod;

public class Main {

	public static void main(String[] args) {
		Trace  trace = TraceFactory.getInstance().getTrace("console");
		trace.setDebug(true);
		trace.debug("I am debut");
		trace.error("I am error");
		
		Trace  traceLog = TraceFactory.getInstance().getTrace("trace.log");
		traceLog.setDebug(true);
		traceLog.debug("I am debut");
		traceLog.error("I am error");
	}

}
