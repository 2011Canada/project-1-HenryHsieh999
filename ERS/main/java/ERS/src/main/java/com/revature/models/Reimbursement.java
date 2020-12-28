package com.revature.models;

import java.sql.Timestamp;

public class Reimbursement {
	
	private int id;
	private double amount;
	private Timestamp submitted;
	private Timestamp resolved;
	private String description;
	private Integer authorID;
	private Integer resolverID;
	private String status;
	private String type;
	
	public Reimbursement() {
		this.id = -1;
		this.resolved = null;
		this.submitted = new Timestamp(System.currentTimeMillis());
		this.description = null;
		this.resolverID = null;
		this.status = null;
	}
	
	public Reimbursement(int id, double amount, Timestamp submitted, Timestamp resolved, String description, Integer authorID,
			Integer resolverID, String status, String type) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.authorID = authorID;
		this.resolverID = resolverID;
		this.status = status;
		this.type = type;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getAuthorID() {
		return authorID;
	}
	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}

	public Integer getResolverID() {
		return resolverID;
	}
	public void setResolverID(int resolverID) {
		this.resolverID = resolverID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Timestamp getSubmitted() {
		return submitted;
	}
	public Timestamp getResolved() {
		return resolved;
	}
	public String getStatus() {
		return status;
	}
	public void approveReimbursement() {
//		if(status != ReimbursementStatus.PENDING) {
//			return;
//		}
//		status = ReimbursementStatus.APPROVED;
//	}
	
	}
	public void declineReimbursement() {
		//TODO throw new error
//		if(status != ReimbursementStatus.PENDING) {
//			return;
//		}
//		status = ReimbursementStatus.DENIED;
	}
}