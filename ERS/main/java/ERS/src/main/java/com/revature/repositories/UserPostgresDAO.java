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

}
