package com.revature.services;

import java.sql.SQLException;
import java.util.List;

import com.revature.models.Reimbursement;

public interface ManagerServiceInterface {
	public List<Reimbursement> viewAllTickets() throws SQLException;
	public List<Reimbursement> viewPending() throws SQLException;
	public List<Reimbursement> viewApproved() throws SQLException;
	public List<Reimbursement> viewDenied() throws SQLException;
	public Reimbursement approveReimbursementStatus(int reimbId) throws SQLException;
	public Reimbursement denyReimbursementStatus(int reimbId) throws SQLException;
}
