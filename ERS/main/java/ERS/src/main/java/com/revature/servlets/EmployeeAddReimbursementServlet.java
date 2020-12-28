package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.controllers.AddReimbursementRequestController;
import com.revature.controllers.ErrorController;
import com.revature.exceptions.UnauthenticatedException;
import com.revature.models.AddReimbursementRequest;
import com.revature.models.Credentials;
import com.revature.models.User;
import com.revature.repositories.UserPostgresDAO;
import com.revature.services.EmployeeServiceImplementation;
import com.revature.services.UserServiceImplementation;

public class EmployeeAddReimbursementServlet extends HttpServlet{

	private AddReimbursementRequestController arrc = new AddReimbursementRequestController();
	
	private ErrorController errorController = new ErrorController();
		
	protected void employeeControlRouter(HttpServletRequest req, HttpServletResponse res) throws JsonParseException, JsonMappingException, IOException {
		System.out.println(this.getInitParameter("DefaultRole"));
//		ServletContext sc = this.getServletContext();
//		
//		System.out.println(sc.getInitParameter("EmployeeController"));
		
		String URI = req.getRequestURI().substring(req.getContextPath().length(), req.getRequestURI().length());
		
		System.out.println(URI);
		switch (URI) {
			case "/reimbursementRequest": {
				switch (req.getMethod()) {
					case "GET":{
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					}
					case "POST":{
						arrc.addReimbursementRequest(req, res);
						System.out.println("post is here");
						break;
					}
					case "PUT":{
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					}
					case "DELETE":{
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					}
					default:{
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					}
				}
				break;
			}
		}
	}
	protected void EmployeeControl(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//to handle all internal errors/exceptions
		try {
			employeeControlRouter(request, response);
		}catch (Throwable t) {
			errorController.handle(request, response, t);//go to the error controller
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		employeeControlRouter(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		employeeControlRouter(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		employeeControlRouter(request, response);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	
}