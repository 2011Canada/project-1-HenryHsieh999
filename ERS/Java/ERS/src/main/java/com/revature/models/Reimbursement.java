package com.revature.models;


public class Reimbursement {
	
	private int reimbursmentID;
	private double amount;
	private Integer authorID;
	private String reimbursementType;
	private String reimbursementStatus;
	private String reimbursementDescription;
	private String reimbusermentSubmitted;
	private String reimbursementResolved;
	
	public Reimbursement() {
		super();
		this.reimbursmentID = -10;
		this.reimbusermentSubmitted = null;
		this.reimbursementStatus = "pending";
		
	}
	
	public Reimbursement(int reimbursmentID, double amount, String reimbusermentSubmitted, String reimbursementResolved, Integer authorID,
			Integer resolverID, String reimbursementStatus, String reimbursementType) {
		super();
		this.reimbursmentID = reimbursmentID;
		this.amount = amount;
		this.setReimbSubmitted(reimbusermentSubmitted);
		this.setReimbResolved(reimbursementResolved);
		this.authorID = authorID;
		this.reimbursementStatus = reimbursementStatus;
		this.reimbursementType = reimbursementType;
	}
	

	public Reimbursement(int id, double amount, String reimbusermentSubmitted, String reimbursementResolved, String reimbursementStatus, String reimbursementType, String reimbursementDescription, int authorID) {
		super();
		this.reimbursmentID = id;
		this.amount = amount;
		this.setReimbSubmitted(reimbusermentSubmitted);
		this.setReimbResolved(reimbursementResolved);
		this.authorID = authorID;
		this.reimbursementStatus = reimbursementStatus;
		this.reimbursementType = reimbursementType;
		this.reimbursementDescription = reimbursementDescription;
	}
	
	public Reimbursement(double amount, String reimbursementType, Integer authorID) {
		super();
		this.amount = amount;
		this.reimbursementType = reimbursementType;
		this.authorID = authorID;
	}
	
	public int getId() {
		return reimbursmentID;
	}
	public void setId(int id) {
		this.reimbursmentID = id;
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
		return reimbusermentSubmitted;
	}

	public void setReimbSubmitted(String reimbursementSubmitted) {
		this.reimbusermentSubmitted = reimbursementSubmitted;
	}

	public String getReimbResolved() {
		return reimbursementResolved;
	}

	public void setReimbResolved(String reimbursementResolved) {
		this.reimbursementResolved = reimbursementResolved;
	}

	public String getReimbursementDescription() {
		return reimbursementDescription;
	}

	public void setReimbursementDescription(String reimbursementDescription) {
		this.reimbursementDescription = reimbursementDescription;
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + reimbursmentID + ", amount=" + amount + ", authorID=" + authorID + ", reimbursementType="
				+ reimbursementType + ", reimbursementStatus=" + reimbursementStatus + ", reimbursementDescription="
				+ reimbursementDescription + ", reimbSubmitted=" + reimbusermentSubmitted + ", reimbResolved=" + reimbursementResolved
				+ "]";
	}
	
	

}