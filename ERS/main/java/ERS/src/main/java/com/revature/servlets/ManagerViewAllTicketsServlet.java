package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.revature.controllers.ErrorController;
import com.revature.controllers.ManagerViewAllTicketsController;
import com.revature.controllers.ViewAllPastTicketsController;
import com.revature.models.ManagerViewAllTickets;


public class ManagerViewAllTicketsServlet extends HttpServlet {

	private ManagerViewAllTicketsController mvatc = new ManagerViewAllTicketsController();
	
	protected void ManagerControlRouter(HttpServletRequest req, HttpServletResponse res) throws JsonParseException, JsonMappingException, IOException {
		System.out.println(this.getInitParameter("DefaultRole"));
		String URI = req.getRequestURI().substring(req.getContextPath().length(), req.getRequestURI().length());
		System.out.println(URI);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		mvatc.managerViewAllTickets(request, response);
		System.out.println("mvatc here");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
