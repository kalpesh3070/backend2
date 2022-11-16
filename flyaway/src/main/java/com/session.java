package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/session")
public class session extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String depart = request.getParameter("from");
		String  disprture = request.getParameter("To");
		String goingOn = request.getParameter("date");
		
		HttpSession session = request.getSession();
		session.setAttribute("depart", depart);
		session.setAttribute("disprture", disprture);
		session.setAttribute("goingOn", goingOn);
		
		response.sendRedirect("booking");
		
	}

}
