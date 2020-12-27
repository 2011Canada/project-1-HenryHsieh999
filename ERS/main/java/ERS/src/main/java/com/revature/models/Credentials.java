package com.revature.models;

public class Credentials {

	private String username;
	
	private String Password;

	public Credentials() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Credentials(String username, String password) {
		super();
		this.username = username;
		Password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public String toString() {
		return "Credentials [username=" + username + ", Password=" + Password + "]";
	}
}
