package mum.asd.chainresponsibility;

import mum.asd.chainresponsibility.model.Address;
import mum.asd.chainresponsibility.model.Agent;
import mum.asd.chainresponsibility.model.CallRecord;
import mum.asd.chainresponsibility.model.Customer;
import mum.asd.chainresponsibility.pattern.AbstractAgent;
import mum.asd.chainresponsibility.pattern.DataWasherAgent;
import mum.asd.chainresponsibility.pattern.ReporterAgent;
import mum.asd.chainresponsibility.pattern.ValidatorAgent;

public class App {
	
	public static AbstractAgent getChainResponsibility() {
		AbstractAgent validator = new ValidatorAgent();   
		AbstractAgent dataWasher = new DataWasherAgent();   
		AbstractAgent reporter = new ReporterAgent(); 
		validator.setNextAgent(dataWasher);
		dataWasher.setNextAgent(reporter);
		return validator;
	}

	public static void main(String []args) {
		Address add = new Address("1000N 4th street", "Fairfiled","Iowa", "52557");
		Agent agent = new Agent("10001",add);
		Customer customer = new Customer("Kimtey", "Chav", add, "9293138539", "kimtey.chav@gmail.com");
		CallRecord record = new CallRecord(customer,agent,"Nothing",false,false);
		
		AbstractAgent processAgent = getChainResponsibility();
		processAgent.handleRequest(record);
		
//		int c = 5;
//		int a,b;
//		for(int i=1;i<=c/2;i++) {
//		    a = i;
//		    b = c
//		}
	}
}
