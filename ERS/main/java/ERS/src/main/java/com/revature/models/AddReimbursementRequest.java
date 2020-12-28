package com.revature.models;

public class AddReimbursementRequest {
	private int userId;
	private String reimbursemntType;
	private Double amount;
	
	public AddReimbursementRequest() {
		super();
	}
	
	public AddReimbursementRequest(int userId, String reimbursmentType, Double amount) {
		super();
		this.setUserId(userId);
		this.reimbursemntType = reimbursmentType;
		this.amount = amount;
	}

	public String getReimbursemntType() {
		return reimbursemntType;
	}

	public void setReimbursemntType(String reimbursemntType) {
		this.reimbursemntType = reimbursemntType;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "AddReimbursementRequest [userId=" + userId + ", reimbursemntType=" + reimbursemntType + ", amount="
				+ amount + "]";
	}
	
}
