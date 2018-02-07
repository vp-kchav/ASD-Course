package com.asd.atm;

public class HasPin implements ATMState {
	
	ATMMachine atmMachine;
	
	public HasPin(ATMMachine newATMMachine){
		
		atmMachine = newATMMachine;
		
	}

	public String insertCard() {
		
		return "You already entered a card";
		
	}

	public String ejectCard() {
		
	
		atmMachine.setATMState(atmMachine.getNoCardState());
		return "Your card is ejected";
		
	}

	public String requestCash(int cashToWithdraw) {
		String ans ="";
		
		if(cashToWithdraw > atmMachine.cashInMachine){
			
			ans+="You don't have that much cash available \n"+"Your card is ejected \n";
			atmMachine.setATMState(atmMachine.getNoCardState());
			return ans;
			
		} else {
			
		ans+=cashToWithdraw + " is provided by the machine \n";
			atmMachine.setCashInMachine(atmMachine.cashInMachine - cashToWithdraw);
			
			ans+="Your card is ejected";
			atmMachine.setATMState(atmMachine.getNoCardState());
			
			if(atmMachine.cashInMachine <= 0){ 
				
				atmMachine.setATMState(atmMachine.getNoCashState());
				
			}
		}
		return ans; 
	}

	public void insertPin(int pinEntered) {
		
		System.out.println("You already entered a PIN");
		
	}	
}