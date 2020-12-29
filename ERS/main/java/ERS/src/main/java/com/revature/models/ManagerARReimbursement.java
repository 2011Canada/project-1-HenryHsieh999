package com.revature.models;

public class ManagerARReimbursement {
	private int reimbId;

	public ManagerARReimbursement() {
		super();
	}
	
	public ManagerARReimbursement(int reimbId) {
		super();
		this.reimbId = reimbId;
	}
	
	public int getReimbId() {
		return reimbId;
	}

	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}

	@Override
	public String toString() {
		return "ManagerARReimbursement [reimbId=" + reimbId + "]";
	}
	
}
