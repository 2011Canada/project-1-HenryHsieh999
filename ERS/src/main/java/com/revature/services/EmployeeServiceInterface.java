package com.revature.services;

import java.sql.SQLException;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface EmployeeServiceInterface {

	List<Reimbursement> viewPastTickets(User user) throws SQLException;

	Reimbursement addFoodReimbursementRequest(User user, Reimbursement reimbursement) throws SQLException;
	Reimbursement addTravelReimbursementRequest(User user, Reimbursement reimbursement) throws SQLException;
	Reimbursement addLodgingReimbursementRequest(User user, Reimbursement reimbursement) throws SQLException;
	Reimbursement addOtherReimbursementRequest(User user, Reimbursement reimbursement) throws SQLException;
}
