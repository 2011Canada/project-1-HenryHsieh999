package com.revature.repositories;

import java.util.List;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Account;
import com.revature.models.User;

public interface UserDAO {
	
	public User findUserByUsernameAndPassword(String username, String password) throws UserNotFoundException;
	public User findUserIdByUsername(String username) throws UserNotFoundException;

	public User findUserByUserId(int id);
	public User findAccountId(int customerId);
	public List<User> findAllUser();
	public List<User> findAllEmployee();
	
	public User createNewCustomerAccount(User u);
	public User createNewBankAccount(User u);

	public User updateBankAccountBalance(User u);
	public User viewBalance(int userId);
	
	public User approveCustomerBankAccount(int userId);
	public User rejectCustomerBankAccount(int userId);
	
	public User checkUserAccountStatus(int userId);
	public User checkUserAccountType(int userId);

	//system auto delete money transfer after accepting
	public User deleteMoneyTransfer(int transferId);
	//add reimbursement
	public User addReimbursementRequest(User u);
	//view past Tickets
	public List<User> viewPastTickets(int id);

	
}
