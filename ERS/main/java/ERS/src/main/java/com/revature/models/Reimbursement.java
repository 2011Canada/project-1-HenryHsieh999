package com.revature.models;

import java.sql.Timestamp;

public class Reimbursement {
	
	private int id;
	private double amount;
	private Integer authorID;
	private String reimbursementType;
	private String reimbursementStatus;
	private String reimbSubmitted;
	private String reimbResolved;
	
	public Reimbursement() {
		super();
		this.id = -10;
		this.reimbSubmitted = null;
		this.reimbursementStatus = "pending";
		
	}
	
	public Reimbursement(int id, double amount, String reimbSubmitted, String reimbResolved, Integer authorID,
			Integer resolverID, String reimbursementStatus, String reimbursementType) {
		super();
		this.id = id;
		this.amount = amount;
		this.setReimbSubmitted(reimbSubmitted);
		this.setReimbResolved(reimbResolved);
		this.authorID = authorID;
		this.reimbursementStatus = reimbursementStatus;
		this.reimbursementType = reimbursementType;
	}
	

	public Reimbursement(int id, double amount, String reimbSubmitted, String reimbResolved, String reimbursementStatus, String reimbursementType, int authorID) {
		super();
		this.id = id;
		this.amount = amount;
		this.setReimbSubmitted(reimbSubmitted);
		this.setReimbResolved(reimbResolved);
		this.authorID = authorID;
		this.reimbursementStatus = reimbursementStatus;
		this.reimbursementType = reimbursementType;
	}
	
	public Reimbursement(double amount, String reimbursementType, Integer authorID) {
		super();
		this.amount = amount;
		this.reimbursementType = reimbursementType;
		this.authorID = authorID;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Integer getAuthorID() {
		return authorID;
	}
	public void setAuthorID(int authorID) {
		this.authorID = authorID;
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

	public String getReimbSubmitted() {
		return reimbSubmitted;
	}

	public void setReimbSubmitted(String reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}

	public String getReimbResolved() {
		return reimbResolved;
	}

	public void setReimbResolved(String reimbResolved) {
		this.reimbResolved = reimbResolved;
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", authorID=" + authorID + ", reimbursementType="
				+ reimbursementType + ", reimbursementStatus=" + reimbursementStatus + ", reimbSubmitted="
				+ reimbSubmitted + ", reimbResolved=" + reimbResolved + "]";
	}

}