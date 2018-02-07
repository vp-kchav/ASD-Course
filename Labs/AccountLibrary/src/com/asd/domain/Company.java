package com.asd.domain;

public class Company extends Customer{

	private int numberOfEmployees;

	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public boolean isPerson() {
		return false;
	}
	
}
