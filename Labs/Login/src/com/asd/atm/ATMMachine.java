package com.asd.atm;
public class ATMMachine {
	
	ATMState hasCard;     
	ATMState noCard;
	ATMState hasCorrectPin;
	ATMState atmOutOfMoney;
	
	ATMState atmState;
	
	int cashInMachine = 2000;
	boolean correctPinEntered = false;
	
	public ATMMachine(){
		
		hasCard = new HasCard(this);
		noCard = new NoCard(this);
		hasCorrectPin = new HasPin(this);
		atmOutOfMoney = new NoCash(this);
		
		atmState = noCard;
		
		if(cashInMachine < 0){
			
			atmState = atmOutOfMoney;
			
		}
		
	}
	
	void setATMState(ATMState newATMState){
		
		atmState = newATMState;
		
	}
	
	public void setCashInMachine(int newCashInMachine){
		
		cashInMachine = newCashInMachine;
		
	}
	
	public String insertCard() {
		
		return atmState.insertCard();
		
	}

	public String ejectCard() {
		
		return atmState.ejectCard();
		
	}

	public String requestCash(int cashToWithdraw) {
		
		return atmState.requestCash(cashToWithdraw);
		
	}

	public void insertPin(int pinEntered){
		
		atmState.insertPin(pinEntered);
		
	}
	
	public ATMState getYesCardState() { return hasCard; }
	public ATMState getNoCardState() { return noCard; }
	public ATMState getHasPin() { return hasCorrectPin; }
	public ATMState getNoCashState() { return atmOutOfMoney; }
	
}