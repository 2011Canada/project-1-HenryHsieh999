package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EmployeeWelcome extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

		res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        RequestDispatcher rd = req.getRequestDispatcher("/employeeMain.html");
        rd.forward(req, res);
    }

}
