	package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		
		
		
		String Firstname = request.getParameter("name");
		String Lastname = request.getParameter("lastname");
		int Age = Integer.parseInt(request.getParameter("age"));
		int phonenumber = Integer.parseInt(request.getParameter("phonenumber"));
		int option = Integer.parseInt(request.getParameter("option"));
		
		HttpSession session = request.getSession();
		String depart = (String)session.getAttribute("depart");
		String disprture = (String)session.getAttribute("disprture");
		String goingOn = (String)session.getAttribute("goingOn");
		
		int res=0;
		
		int ticketprice=0;
		if(option>1) {
			 ticketprice=option*3000;
		}
		else if(option==1){
			 ticketprice=3000;
		}
		
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/airlines","root","@Prem2arul");
		System.out.println("Connection");
		Statement st = con.createStatement();
		 res = st.executeUpdate("insert into customer_details value('"+ Firstname + "','" + Lastname + "'," +Age+ "," +phonenumber+ ","+ ticketprice+ ",'"+depart+"','"+disprture+"','"+goingOn+"')");
	
	
	}
	
	catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		out.print("class not found");
		e.printStackTrace();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		out.println("sql erroe");
		
	}
	
	if(res==1) {
		RequestDispatcher rd = request.getRequestDispatcher("main.html");
		rd.forward(request, response);
	}
	else {
		RequestDispatcher rd = request.getRequestDispatcher("Ticket_booking.html");
		rd.include(request, response);
	}
	
	
	}
}