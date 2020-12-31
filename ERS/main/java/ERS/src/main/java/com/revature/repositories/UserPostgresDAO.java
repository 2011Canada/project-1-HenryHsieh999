package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class UserPostgresDAO implements UserDAO{
	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
	public User findUserByUsernameAndPassword(String username, String password) throws UserNotFoundException {
		Connection conn = cf.getConnection();
		try {
			String sql = "select * from ers_user_roles eur left join ers_users eu on eur.ers_user_role_id = eu.user_roles_fk where ers_username = ? and ers_password = ?;";
			PreparedStatement getUser = conn.prepareStatement(sql);
			getUser.setString(1, username);
			getUser.setString(2, password);
			ResultSet res = getUser.executeQuery();
			if(res.next()) {
				User u = new User();
				u.setUserId(res.getInt("ers_user_role_id"));
				u.setFirstName(res.getString("user_first_name"));
				u.setLastName(res.getString("user_last_name"));
				u.setUsername(res.getString("ers_username"));
				u.setPassword(res.getString("ers_password"));
				u.setEmail(res.getString("user_email"));
				u.setTpe(res.getString("user_role"));
				return u;
			}else {
				throw new UserNotFoundException();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			cf.releaseConnection(conn);
		}
		return null;
	}
	
	public User findUserIdByUsername(String username) throws UserNotFoundException {
		Connection conn = cf.getConnection();
		try {
			String sql = "select * from ers_user_roles eur left join ers_users eu on eur.ers_user_role_id = eu.user_roles_fk where ers_username = ?;";
			PreparedStatement getUser = conn.prepareStatement(sql);
			getUser.setString(1, username);
			
			ResultSet res = getUser.executeQuery();
			if(res.next()) {
				User u = new User();
				u.setUserId(res.getInt("user_roles_fk"));
				return u;
			}else {
				throw new UserNotFoundException();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			cf.releaseConnection(conn);
		}
		return null;
	}
	
	public User createNewCustomerAccount(User u) {
		Connection conn = cf.getConnection();
		try {
			String sql = "insert into users (fname, lname, user_name, user_password , user_status, tpe) values (?,?,?,?,?,?) returning user_id;";
			PreparedStatement insertNewCustomerAccount = conn.prepareStatement(sql);
			insertNewCustomerAccount.setString(1, u.getFirstName());
			insertNewCustomerAccount.setString(2, u.getLastName());
			insertNewCustomerAccount.setString(3,  u.getUsername());
			insertNewCustomerAccount.setString(4, u.getPassword());
			insertNewCustomerAccount.setString(5,  "inactive");
			insertNewCustomerAccount.setString(6, "customer");
			ResultSet res = insertNewCustomerAccount.executeQuery();
			while(res.next()) {
				u.setUserId(res.getInt("user_id"));
				return u;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			cf.releaseConnection(conn);
		}
		return u;
	}
	
	public User createNewBankAccount(User u) {
		Connection conn = cf.getConnection();
		try {
			String sql = "insert into account (balance, customer_id) values (?, ?);";
			PreparedStatement insertNewBankAccount = conn.prepareStatement(sql);
			insertNewBankAccount.setDouble(1, 0);
			insertNewBankAccount.setInt(2, u.getUserId());
			insertNewBankAccount.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			cf.releaseConnection(conn);
		}
		return u;
	
	}
	public User findUserByUserId(int id) {
		Connection conn = cf.getConnection();
		try {
			String sql = "select * from ers_user_roles eur left join ers_users eu on eur.ers_user_role_id = eu.user_roles_fk where ers_user_role_id = ?;";
			PreparedStatement findUserByid = conn.prepareStatement(sql);
			findUserByid.setInt(1, id);
			ResultSet res = findUserByid.executeQuery();
		if(res.next()) {
			User u = new User();
			u.setUserId(res.getInt("ers_user_role_id"));
			u.setFirstName(res.getString("user_first_name"));
			u.setLastName(res.getString("user_last_name"));
			u.setEmail(res.getString("user_email"));
			u.setTpe(res.getString("user_role"));
			return u;
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			cf.releaseConnection(conn);
		}
		return null;
	}

	
	public User approveCustomerBankAccount(int userId) {
		Connection conn = cf.getConnection();
		try {
			String sql = "update users set user_status = 'active' where user_id = ?;";
			PreparedStatement getBalance = conn.prepareStatement(sql);
			getBalance.setInt(1, userId);
			getBalance.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			cf.releaseConnection(conn);
		}
		return null;
	}
	
	public User rejectCustomerBankAccount(int userId) {
		Connection conn = cf.getConnection();
		try {
			String sql = "update users set user_status = 'inactive' where user_id = ?;";
			PreparedStatement getBalance = conn.prepareStatement(sql);
			getBalance.setInt(1, userId);
			getBalance.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			cf.releaseConnection(conn);
		}
		return null;
	}
	
	
	public User viewBalance(int userId) {
		Connection conn = cf.getConnection();
		try {
			String sql = "select * from account where customer_id = ?";
			PreparedStatement getBalance = conn.prepareStatement(sql);
			getBalance.setInt(1, userId);
			ResultSet res = getBalance.executeQuery();
			while(res.next()) {
				User u = new User();
				u.setUserId(res.getInt("customer_id"));
				return u;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			cf.releaseConnection(conn);
		}
		return null;
	}
	
	public User updateBankAccountBalance(User u) {
		Connection conn = cf.getConnection();
		try {
			String sql = "update account set balance = ? where customer_id = ?;";
			PreparedStatement updateBankAccountBalance = conn.prepareStatement(sql);
			updateBankAccountBalance.setInt(2, u.getUserId());
			updateBankAccountBalance.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			cf.releaseConnection(conn);
		}
		return u;
	}
	public User checkUserAccountStatus(int userId) {
		Connection conn = cf.getConnection();
		try {
			String sql = "select * from users where user_id = ?";
			PreparedStatement checkUserAccountStatus = conn.prepareStatement(sql);
			checkUserAccountStatus.setInt(1, userId);
			ResultSet res = checkUserAccountStatus.executeQuery();
			while(res.next()) {
				User u = new User();
				u.setUserId(res.getInt("user_id"));
				return u;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			cf.releaseConnection(conn);
		}
		return null;
	}	
	
	public User checkUserAccountType(int userId) {
		Connection conn = cf.getConnection();
		try {
			String sql = "select * from users where user_id = ?";
			PreparedStatement checkUserAccountType = conn.prepareStatement(sql);
			checkUserAccountType.setInt(1, userId);
			ResultSet res = checkUserAccountType.executeQuery();
			while(res.next()) {
				User u = new User();
				u.setUserId(res.getInt("user_id"));
				u.setTpe(res.getString("tpe"));
				return u;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			cf.releaseConnection(conn);
		}
		return null;
	}
	public User findAccountId(int customerId) {
		Connection conn = cf.getConnection();
		try {
			String sql = "select * from account where customer_id = ?;";
			PreparedStatement findAccountId = conn.prepareStatement(sql);
			findAccountId.setInt(1, customerId);
			ResultSet res = findAccountId.executeQuery();
		if(res.next()) {
			User u = new User();
			u.setUserId(res.getInt("customer_id"));
			return u;
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			cf.releaseConnection(conn);
		}
		return null;
	}
	public List<User> findAllUser() {
			Connection conn = cf.getConnection();
			List<User> u = new ArrayList<User>();
			try {
				String sql = "select * from users u left join account a on u.user_id = a.customer_id where tpe = 'customer';";
				Statement s = conn.createStatement();
				
				ResultSet res = s.executeQuery(sql);
				while(res.next()) {
//					Customer c = new Customer(res.getInt("user_id"), res.getInt("account_id"), res.getString("user_name"), res.getString("fname"), res.getString("lname"), res.getString("user_status"), res.getDouble("balance"), res.getString("tpe"));
//					u.add(c);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			} finally {
				cf.releaseConnection(conn);
			}
			return u;
		}
	public List<User> findAllEmployee() {
		Connection conn = cf.getConnection();
		List<User> u = new ArrayList<User>();
		try {
			String sql = "select * from users u left join account a on u.user_id = a.customer_id where tpe = 'employee';";
			Statement s = conn.createStatement();
			ResultSet res = s.executeQuery(sql);
			while(res.next()) {
//				Customer c = new Customer(res.getInt("user_id"), res.getInt("account_id"), res.getString("user_name"), res.getString("fname"), res.getString("lname"), res.getString("user_status"), res.getDouble("balance"), res.getString("tpe"));
//				u.add(c);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			cf.releaseConnection(conn);
		}
		return u;
	}

	
	public User deleteMoneyTransfer(int transferId) {
		Connection conn = cf.getConnection();
		try {
			String sql = "delete from money_transfer where transfer_id = ?;";
			PreparedStatement deleteMoneyTransfer = conn.prepareStatement(sql);
			deleteMoneyTransfer.setInt(1, transferId);
			deleteMoneyTransfer.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			cf.releaseConnection(conn);
		}
		return null;
	}

	

	@Override
	public List<User> managerViewAllTickets() {
		Connection conn = cf.getConnection();
		List<User> u = new ArrayList<User>();
		try {
			String sql = "select * from ers_reimbursement;";
			Statement s = conn.createStatement();
			ResultSet res = s.executeQuery(sql);
			while(res.next()) {
//				Employee e = new Employee(res.getInt("reimb_id"), res.getDouble("reimb_amount"), res.getTimestamp("reimb_submitted"), res.getString("reimb_status"), res.getString("reimb_type"), res.getInt("ers_reimb_author"));
//				u.add(e);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			cf.releaseConnection(conn);
		}
		return u;
	}

	public User approveReimbursement(int reimbId) {
		Connection conn = cf.getConnection();
		try {
			String sql = "update ers_reimbursement set reimb_status = 'approved' where reimb_id = ?;";
			PreparedStatement approveReimbursement = conn.prepareStatement(sql);
			approveReimbursement.setInt(1, reimbId);
			approveReimbursement.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			cf.releaseConnection(conn);
		}
		return null;
	}

	public User rejectReimbursement(int reimbId) {
		Connection conn = cf.getConnection();
		try {
			String sql = "update ers_reimbursement set reimb_status = 'rejected' where reimb_id = ?;";
			PreparedStatement approveReimbursement = conn.prepareStatement(sql);
			approveReimbursement.setInt(1, reimbId);
			approveReimbursement.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			cf.releaseConnection(conn);
		}
		return null;
	}

	public List<User> filterRequestByStatus(String reqStatus) {
		Connection conn = cf.getConnection();
		List<User> u = new ArrayList<User>();
		try {
			String sql = "select * from ers_reimbursement where reimb_status = ?;";
			PreparedStatement filterRequestByStatus = conn.prepareStatement(sql);
			filterRequestByStatus.setString(1, reqStatus);
			ResultSet res = filterRequestByStatus.executeQuery();
			while(res.next()) {
//				Employee e = new Employee(res.getInt("reimb_id"), res.getDouble("reimb_amount"), res.getTimestamp("reimb_submitted"), res.getString("reimb_status"), res.getString("reimb_type"), res.getInt("ers_reimb_author"));
//				u.add(e);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			cf.releaseConnection(conn);
		}
		return u;
	}

}
