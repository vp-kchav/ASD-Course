package mum.asd.chainresponsibility.pattern;

import mum.asd.chainresponsibility.model.CallRecord;

public class DataWasherAgent extends AbstractAgent {

	@Override
	public void handleRequest(CallRecord callrecord) {
		System.out.println("done some analysis");
		System.out.println("generated sales leads");
		callrecord.setASalesLead(true);
		getNextAgent().handleRequest(callrecord);
	}

}
