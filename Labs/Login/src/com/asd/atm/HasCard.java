package com.asd.atm;

public class HasCard implements ATMState {
ATMMachine atmMachine;
	
	public HasCard(ATMMachine newATMMachine){
		
		atmMachine = newATMMachine;
		
	}

	public String insertCard() {
		
	return "You can only insert one card at a time";
		
	}

	public String ejectCard() {
		
		
		//atmMachine.setATMState(atmMachine.getNoCardState());
		return "Your card is ejected";
		
	}

	public String requestCash(int cashToWithdraw) {
		
		
		return "You have not entered your PIN";
		
		
	}

	public void insertPin(int pinEntered) {
		
		if(pinEntered == 1234){
			
			System.out.println("You entered the correct PIN");
			atmMachine.correctPinEntered = true;
			atmMachine.setATMState(atmMachine.getHasPin());
			
		} else {
			
			System.out.println("You entered the wrong PIN");
			atmMachine.correctPinEntered = false;
			System.out.println("Your card is ejected");
			atmMachine.setATMState(atmMachine.getNoCardState());
			
		}	
	}
}
