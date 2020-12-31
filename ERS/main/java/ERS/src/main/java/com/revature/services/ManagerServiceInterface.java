package com.revature.services;

import java.sql.SQLException;
import java.util.List;

import com.revature.models.Reimbursement;

public interface ManagerServiceInterface {
	public List<Reimbursement> viewAllTickets() throws SQLException;
	public List<Reimbursement> filterReimbursementStatus(String reimbStatus) throws SQLException;
	public Reimbursement updateReimbursementStatus(int reimbId, String reimbStatus) throws SQLException;
}
