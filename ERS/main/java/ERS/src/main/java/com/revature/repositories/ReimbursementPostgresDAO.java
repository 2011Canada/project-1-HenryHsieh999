package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class ReimbursementPostgresDAO implements ReimbursementDAO{
	
	private static ConnectionFactory cf = ConnectionFactory.getConnectionFactory();

	public List<Reimbursement> getAllReimbursements() throws SQLException {
		Connection conn = cf.getConnection();
		List<Reimbursement> reimbursementList = new ArrayList<>();
		try {
			String sql = "select * from ers_reimbursement;";
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet res = statement.executeQuery();
		
			while (res.next()) {
				reimbursementList.add(new Reimbursement(res.getInt("reimb_id"), res.getDouble("reimb_amount"), res.getString("reimb_submitted"), res.getString("reimb_resolved"), res.getString("reimb_status"),res.getString("reimb_type"), res.getInt("ers_reimb_author")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			cf.releaseConnection(conn);
		}
		return reimbursementList;
	}

	@Override
	public List<Reimbursement> getAllReimbursementsByUser(User user) throws SQLException {
		Connection conn = cf.getConnection();
		List<Reimbursement> reimbursementList = new ArrayList<>();
		try {
			String sql = "select * from ers_reimbursement where ers_reimb_author = ?;";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, user.getUserId());
			ResultSet res = statement.executeQuery();
	
			
			while (res.next()) {
				reimbursementList.add(new Reimbursement(res.getInt("reimb_id"), res.getDouble("reimb_amount"), res.getString("reimb_submitted"), res.getString("reimb_resolved"), res.getString("reimb_status"), res.getString("reimb_type"), res.getInt("ers_reimb_author")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			cf.releaseConnection(conn);
		}
		return reimbursementList;
	}

	@Override
	public Reimbursement updateReimbursementStatus(int reimbId, String reimbStatus) throws SQLException {
		Connection conn = cf.getConnection();
		final java.util.Date today = new java.util.Date();
		final java.sql.Timestamp todaySQL = new java.sql.Timestamp(today.getTime());
		try {
			String sql = "update ers_reimbursement set reimb_status = ?, reimb_resolved = ? where reimb_id = ?;";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, reimbStatus);
			statement.setTimestamp(2, todaySQL);
			statement.setInt(3, reimbId);
			statement.executeUpdate();		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			cf.releaseConnection(conn);
		}
		return null;
	}
	
	@Override
	public Reimbursement addReimbursement(Reimbursement reimbursement) throws SQLException {
		Connection conn = cf.getConnection();
		try {
			String sql = "insert into ers_reimbursement (reimb_amount, reimb_submitted, reimb_status, reimb_type, ers_reimb_author) values (?, ?, ?, ?, ?) returning reimb_id;";
			PreparedStatement statement = conn.prepareStatement(sql);
			final java.util.Date today = new java.util.Date();
			final java.sql.Timestamp todaySQL = new java.sql.Timestamp(today.getTime());
			statement.setDouble(1, reimbursement.getAmount());
			statement.setTimestamp(2, todaySQL);
			statement.setString(3, "pending");
			statement.setString(4, reimbursement.getReimbursementType());
			statement.setInt(5, reimbursement.getAuthorID());
			
			ResultSet res = statement.executeQuery();
			res.next();
			reimbursement.setId(res.getInt("reimb_id"));
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			cf.releaseConnection(conn);
		}
		return reimbursement;
	}

	@Override
	public Reimbursement getAllReimbursementsByID(int reimID) throws SQLException {
		Connection conn = cf.getConnection();
		
			String sql = "select * from ers_reimbursement where ers_reimb_author = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, reimID);
			ResultSet res = statement.executeQuery();
			
			Reimbursement reimbursement = new Reimbursement(res.getInt("reimb_id"), res.getDouble("reimb_amount"), res.getString("reimb_submitted"), res.getString("reimb_resolved"), res.getString("reimb_status"), res.getString("reimb_type"), res.getInt("ers_reimb_author"));
		
		return reimbursement;
	}

	@Override
	public List<Reimbursement> getAllPendingReimbursements() throws SQLException {
		Connection conn = cf.getConnection();
		List<Reimbursement> reimbursementList = new ArrayList<>();
		try {
			String sql = "select * from ers_reimbursement where reimb_status = 'pending';";
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet res = statement.executeQuery();
	
			while (res.next()) {
				reimbursementList.add(new Reimbursement(res.getInt("reimb_id"), res.getDouble("reimb_amount"), res.getString("reimb_submitted"), res.getString("reimb_resolved"), res.getString("reimb_status"), res.getString("reimb_type"), res.getInt("ers_reimb_author")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			cf.releaseConnection(conn);
		}
		return reimbursementList;
	}

	@Override
	public List<Reimbursement> getAllApprovedReimbursements() throws SQLException {
		Connection conn = cf.getConnection();
		List<Reimbursement> reimbursementList = new ArrayList<>();
		try {
			String sql = "select * from ers_reimbursement where reimb_status = 'approved';";
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet res = statement.executeQuery();
			while (res.next()) {
				reimbursementList.add(new Reimbursement(res.getInt("reimb_id"), res.getDouble("reimb_amount"), res.getString("reimb_submitted"), res.getString("reimb_resolved"), res.getString("reimb_status"), res.getString("reimb_type"), res.getInt("ers_reimb_author")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			cf.releaseConnection(conn);
		}
		return reimbursementList;
	}

	@Override
	public List<Reimbursement> getAllDeniedReimbursements() throws SQLException {
		Connection conn = cf.getConnection();
		List<Reimbursement> reimbursementList = new ArrayList<>();
		try {
			String sql = "select * from ers_reimbursement where reimb_status = 'denied';";
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet res = statement.executeQuery();
	
			while (res.next()) {
				reimbursementList.add(new Reimbursement(res.getInt("reimb_id"), res.getDouble("reimb_amount"), res.getString("reimb_submitted"), res.getString("reimb_resolved"), res.getString("reimb_status"), res.getString("reimb_type"), res.getInt("ers_reimb_author")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			cf.releaseConnection(conn);
		}
		return reimbursementList;
	}

}
