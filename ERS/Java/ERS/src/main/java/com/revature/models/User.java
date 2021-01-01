package com.revature.models;

import java.sql.Timestamp;

public class User{
	
	private int userId;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String tpe;
	private String email;
	
	public User() {
		super();
	}
	public User(int userId) {
		this.userId = userId;
	}

	public User(String username, String password, String fName, String lName) {
		this.username = username;
		this.password = password;
		this.firstName = fName;
		this.lastName = lName;
	}

	public User(int userId, String username, String firstName, String lastName, String email, String tpe) {
		this.userId = userId;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.tpe = tpe;
	}
	public User(int userId, String username, String password, String firstName, String lastName) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}


	

	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setTpe(String tpe) {
		this.tpe = tpe;
	}
	
	public String getTpe() {
		return tpe;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", tpe=" + tpe + ", email=" + email + "]";
	}

	
	
	

}