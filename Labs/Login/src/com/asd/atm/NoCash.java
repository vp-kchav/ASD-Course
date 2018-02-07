package com.asd.atm;


	public class NoCash implements ATMState {
		
		ATMMachine atmMachine;
		
		public NoCash(ATMMachine newATMMachine){
			
			atmMachine = newATMMachine;
			
		}

		public String insertCard() {
			
			return "We don't have any money \n" +"Your card is ejected";
			
		}

		public String ejectCard() {
			
			return "We don't have any money \n"+"There is no card to eject";
			
		}

		public String requestCash(int cashToWithdraw) {
			
			return  "We don't have any money";
			
		}

		public void insertPin(int pinEntered) {
			
			System.out.println("We don't have any money");
			
		}
	}
	