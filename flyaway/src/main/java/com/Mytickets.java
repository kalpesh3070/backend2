package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Mytickets")
public class Mytickets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		 int phonenumber = Integer.parseInt(request.getParameter("phonenumber"));
		
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/airlines","root","@Prem2arul");
				
				Statement pst = con.createStatement();
			
				
			    String sql ="select * from customer_details where phonenumber="+phonenumber+" ";
				
				ResultSet rs = pst.executeQuery(sql);
				
				
				out.println("<hr><br><table cellspacing='0' cellpadding='10' border='1'>");
				out.println("<tr>");
				
				out.println("<td> FirstName</td>");
				out.println("<td>LastName </td>");
				out.println("<td>Age</td>");
				out.println("<td>PassportNumber</td>");
				out.println("<td>TicketPrice</td>");
				out.println("<td>depart</td>");
				out.println("<td>disprture</td>");
				out.println("<td>goingOn</td>");
				
				out.println("<td>Cancel</td>");
				out.println("</tr>");
			
				while(rs.next()) {
					out.println("<tr>");
					out.println("<td>" +  rs.getString("Firstname")+"</td>");
					out.println("<td>" +  rs.getString("Lastname")+"</td>");
					out.println("<td>" +  rs.getInt("Age")+"</td>");
					out.println("<td>" +  rs.getInt("phonenumber")+"</td>");
					out.println("<td>" +  rs.getInt("ticketprice")+"</td>");
					out.println("<td>" +  rs.getString("depart")+"</td>");
					out.println("<td>" +  rs.getString("disprture")+"</td>");
					out.println("<td>" +  rs.getString("goingOn")+"</td>");
					
					out.println("<td>" + "<a href='http://localhost:8080/flyaway/main.html'> HOME</a>"+"</td>");
					out.println("</tr>");
				
				
				
				
				
				}	
				
				
				
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
		 
		

	}
}
