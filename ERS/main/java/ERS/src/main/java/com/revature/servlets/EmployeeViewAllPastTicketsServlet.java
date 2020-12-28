package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.revature.controllers.AddReimbursementRequestController;
import com.revature.controllers.ErrorController;
import com.revature.controllers.ViewAllPastTicketsController;


public class EmployeeViewAllPastTicketsServlet extends HttpServlet {
	
	private ViewAllPastTicketsController vaptc = new ViewAllPastTicketsController();
	
	private ErrorController errorController = new ErrorController();
		
	protected void employeeControlRouter(HttpServletRequest req, HttpServletResponse res) throws JsonParseException, JsonMappingException, IOException {
		System.out.println(this.getInitParameter("DefaultRole"));
		
		String URI = req.getRequestURI().substring(req.getContextPath().length(), req.getRequestURI().length());
		
		System.out.println(URI);
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		vaptc.viewAllPastTickets(request, response);
		System.out.println("vaptc here");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
