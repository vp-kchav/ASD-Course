package com.asd.atm;

interface  ATMState {
	String insertCard();
	String ejectCard();
	void insertPin(int pin);
	String requestCash(int money);
}
