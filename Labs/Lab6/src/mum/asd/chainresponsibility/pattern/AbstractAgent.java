package mum.asd.chainresponsibility.pattern;

import mum.asd.chainresponsibility.model.CallRecord;

public abstract class AbstractAgent {
	private AbstractAgent nextAgent;
	
	public void setNextAgent(AbstractAgent nextAgent) {
		this.nextAgent = nextAgent;
	}

	public AbstractAgent getNextAgent() {
		return nextAgent;
	}
	
	public abstract void handleRequest(CallRecord callrecord);
	
}
