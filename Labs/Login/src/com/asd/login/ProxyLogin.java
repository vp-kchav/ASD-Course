package com.asd.login;

public class ProxyLogin implements Login {

	private CheckLogin check;
	private String user;
	private String pass;
	
	
	public ProxyLogin(String user, String pass) {
		this.user = user;
		this.pass = pass;
	}


	@Override
	public boolean exec(String user, String pass) {
		if (check != null) {
			check = new CheckLogin(user, pass);
		}
		return check.exec(user, pass);
	}
}
