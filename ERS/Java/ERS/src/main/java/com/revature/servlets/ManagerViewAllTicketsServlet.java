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


public class ManagerViewAllTicketsServlet extends HttpServlet {
	
	private ManagerServiceImplementation msi = new ManagerServiceImplementation();
	private ObjectMapper om = new ObjectMapper();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		System.out.println("Session:");
		HttpSession sess = req.getSession(false);		
		System.out.println(sess);
		
		List<Reimbursement> allTickets = null;
		System.out.println("get is here");
		try {
			allTickets = msi.viewAllTickets();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		res.setStatus(200);
		if(null == allTickets) {
			allTickets = new ArrayList<>();
		}
		res.getWriter().write(om.writeValueAsString(allTickets));
	}

}
