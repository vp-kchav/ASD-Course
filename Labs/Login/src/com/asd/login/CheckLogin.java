package com.asd.login;

public class CheckLogin implements Login {

	private String user;
	private String pass;

	public CheckLogin(String user, String pass) {
		this.user = user;
		this.pass = pass;
		exec(user, pass);
	}

	@Override
	public boolean exec(String user, String pass) {
		if (user.equals("user") && pass.equals("pass")) {
			return true;
		}
		return false;
	}

}
