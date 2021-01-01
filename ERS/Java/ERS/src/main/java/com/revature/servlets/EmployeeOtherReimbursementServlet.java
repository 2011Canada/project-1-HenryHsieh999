package com.revature.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.EmployeeServiceImplementation;

/**
 * Servlet implementation class EmployeeOtherReimbursementServlet
 */
public class EmployeeOtherReimbursementServlet extends HttpServlet {
    
	private EmployeeServiceImplementation esi = new EmployeeServiceImplementation();
	
	private ObjectMapper om = new ObjectMapper();
	

protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Session: ");
		HttpSession sess = req.getSession(false);		
		System.out.println(sess);
		User u = (User)sess.getAttribute("user");
		Reimbursement r = null;
		System.out.println("Post is here:");
		try {
			r = om.readValue(req.getInputStream(), Reimbursement.class);
			r.setAuthorID(u.getUserId());
			System.out.println(r);
			r = esi.addOtherReimbursementRequest(u, r);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		res.setStatus(200);
		res.getWriter().write(om.writeValueAsString(r));
	}

}
