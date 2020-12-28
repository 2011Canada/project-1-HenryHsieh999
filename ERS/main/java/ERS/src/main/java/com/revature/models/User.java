package com.revature.models;

import java.sql.Timestamp;

public class User{
	
	private int userId;
	private int reimbId;
	private Double amount;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String tpe;
	private String email;
	private String reimbursementType;
	private String reimbursementStatus;
	private Timestamp reimbSubmitted;
	private Timestamp reimbResolved;
	
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

	public User(double amount, Timestamp reimbSubmitted , String reimbStatus, String reimbType, int userId) {
		super();
		this.amount = amount;
		this.setReimbSubmitted(reimbSubmitted);
		this.setReimbursementStatus(reimbStatus);
		this.reimbursementType = reimbType;
		this.userId = userId;
	}
	public User(int ersReimbAuthor, int reimbId, double amount, Timestamp reimbSubmitted, Timestamp reimbResolved,	String reimbStatus, String reimbType) {
		super();
		this.userId = ersReimbAuthor;
		this.reimbId = reimbId;
		this.amount = amount;
		this.setReimbSubmitted(reimbSubmitted);
		this.setReimbResolved(reimbResolved);
		this.reimbursementStatus = reimbStatus;
		this.reimbursementType = reimbType;		
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

	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getReimbursementType() {
		return reimbursementType;
	}
	public void setReimbursementType(String reimbursementType) {
		this.reimbursementType = reimbursementType;
	}

	public String getReimbursementStatus() {
		return reimbursementStatus;
	}
	public void setReimbursementStatus(String reimbursementStatus) {
		this.reimbursementStatus = reimbursementStatus;
	}

	public int getReimbId() {
		return reimbId;
	}
	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}
	public Timestamp getReimbSubmitted() {
		return reimbSubmitted;
	}
	public void setReimbSubmitted(Timestamp reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}
	public Timestamp getReimbResolved() {
		return reimbResolved;
	}
	public void setReimbResolved(Timestamp reimbResolved) {
		this.reimbResolved = reimbResolved;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", reimbId=" + reimbId + ", amount=" + amount + ", username=" + username
				+ ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName + ", tpe=" + tpe
				+ ", email=" + email + ", reimbursementType=" + reimbursementType + ", reimbursementStatus="
				+ reimbursementStatus + ", reimbSubmitted=" + reimbSubmitted + ", reimbResolved=" + reimbResolved + "]";
	}
	
	

}