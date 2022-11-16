package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		int res =0;
		 int phonenumber = Integer.parseInt(request.getParameter("phonenumber"));
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/airlines","root","@Prem2arul");
				
				
				
				Statement pst = con.createStatement();
				
				String sql ="delete from customer_details where( phonenumber="+phonenumber+")";
				
				 res = pst.executeUpdate(sql);
				
				 
					
					
	}
		 
		 catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				out.print("class not found");
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
	