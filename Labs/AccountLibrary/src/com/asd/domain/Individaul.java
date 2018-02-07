package com.asd.domain;

import java.util.Date;

public class Individaul extends Customer{
	private Date birthDate;

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public boolean isPerson() {
		return true;
	}

}
