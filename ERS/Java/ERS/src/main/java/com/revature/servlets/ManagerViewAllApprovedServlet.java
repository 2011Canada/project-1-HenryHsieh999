package com.revature.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.services.ManagerServiceImplementation;

/**
 * Servlet implementation class ManagerViewAllApprovedServlet
 */
public class ManagerViewAllApprovedServlet extends HttpServlet {
	private ManagerServiceImplementation msi = new ManagerServiceImplementation();
	private ObjectMapper om = new ObjectMapper();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		System.out.println("Session:");
		HttpSession sess = req.getSession(false);		
		System.out.println(sess);
		
		List<Reimbursement> allApprovedTickets = null;
		System.out.println("get is here");
		try {
			allApprovedTickets = msi.viewApproved();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		res.setStatus(200);
		if(null == allApprovedTickets) {
			allApprovedTickets = new ArrayList<>();
		}
		res.getWriter().write(om.writeValueAsString(allApprovedTickets));
	}

}
