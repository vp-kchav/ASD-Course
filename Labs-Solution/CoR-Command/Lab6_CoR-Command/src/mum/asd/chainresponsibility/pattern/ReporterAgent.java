package mum.asd.chainresponsibility.pattern;

import mum.asd.chainresponsibility.model.CallRecord;

public class ReporterAgent extends AbstractAgent {

	@Override
	public void handleRequest(CallRecord callrecord) {
		System.out.println("Generated report and sent to " + callrecord.getCustomer().getAddress().getState());
	}

}
