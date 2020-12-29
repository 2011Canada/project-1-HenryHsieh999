package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.ErrorController;
import com.revature.controllers.ManagerApproveReimbursementController;
import com.revature.controllers.ManagerRejectReimbursementController;

/**
 * Servlet implementation class ManagerARReimbursement
 */
public class ManagerARReimbursementServlet extends HttpServlet {
	
	private ManagerApproveReimbursementController marc = new ManagerApproveReimbursementController();
	
	private ManagerRejectReimbursementController mrrc = new ManagerRejectReimbursementController();
	
	private ErrorController errorController = new ErrorController();
	
	protected void managerARRControlRouter(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println(this.getInitParameter("DefaultRole"));
//		ServletContext sc = this.getServletContext();
//		
//		System.out.println(sc.getInitParameter("EmployeeController"));
		
		String URI = req.getRequestURI().substring(req.getContextPath().length(), req.getRequestURI().length());
		
		System.out.println(URI);
		switch (URI) {
			case "/ManagerARReimbursement": {
				switch (req.getMethod()) {
					case "GET":{
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					}
					case "POST":{
						//todo maybe merge managerapprove and reject together in controllers
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
			managerARRControlRouter(request, response);
		}catch (Throwable t) {
			errorController.handle(request, response, t);//go to the error controller
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		managerARRControlRouter(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		managerARRControlRouter(request, response);
	}
	
}
