package com.asd.atm;


	public class NoCard implements ATMState {
		
		ATMMachine atmMachine;
		
		public NoCard(ATMMachine newATMMachine){
			
			atmMachine = newATMMachine;
			
		}

		public String insertCard() {
			
			
			atmMachine.setATMState(atmMachine.getYesCardState());
			return "Please enter your pin";
			
		}

		public String ejectCard() {
			
			return "You didn't enter a card"
					;
			
		}

		public String requestCash(int cashToWithdraw) {
			
			return "You have not entered your card";
			
		}

		public void insertPin(int pinEntered) {
			
			System.out.println("You have not entered your card");
			
		}
	}


