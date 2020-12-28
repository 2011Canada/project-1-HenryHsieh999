package com.revature.servlets;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.repositories.UserPostgresDAO;
import com.revature.services.EmployeeServiceImplementation;

public class AddReimbursementServlet extends HttpServlet {
	
	private EmployeeServiceImplementation esi = new EmployeeServiceImplementation(new UserPostgresDAO());
	private ObjectMapper om = new ObjectMapper();
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession(false);
		User u = (User)sess.getAttribute("userID");
		
	}

}
