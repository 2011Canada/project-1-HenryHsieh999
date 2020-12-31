package com.revature.repositories;

import java.sql.SQLException;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface ReimbursementDAO {
	//employee
	Reimbursement addReimbursement(Reimbursement reimbursement) throws SQLException;
	List<Reimbursement> getAllReimbursementsByUser(User user) throws SQLException;
	
	//manager
	Reimbursement getAllReimbursementsByID(int reimID) throws SQLException;
	List<Reimbursement> getAllReimbursements() throws SQLException;
	List<Reimbursement> getAllReimbursementsByStatus(String status) throws SQLException;
	Reimbursement updateReimbursementStatus(int reimbId, String reimbStatus) throws SQLException;
	
}
