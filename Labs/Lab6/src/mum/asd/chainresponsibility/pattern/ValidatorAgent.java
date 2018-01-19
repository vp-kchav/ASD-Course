package mum.asd.chainresponsibility.pattern;

import mum.asd.chainresponsibility.model.CallRecord;

public class ValidatorAgent extends AbstractAgent {

	@Override
	public void handleRequest(CallRecord callrecord) {
		if(!callrecord.getCustomer().getEmail().isEmpty() &&
				!callrecord.getCustomer().getPhone().isEmpty() && 
				callrecord.getCustomer().getAddress() != null) {
			callrecord.setValid(true);
			System.out.println("customer is Valid");
			getNextAgent().handleRequest(callrecord);
		} else {
			System.out.println("This customer is invalid!!! Saved to discarded-requests" );
		}
	}

}
