package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;


@WebServlet("/booking")
public class booking extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		String depart = (String)session.getAttribute("depart");
		String disprture = (String)session.getAttribute("disprture");
		String goingOn = (String)session.getAttribute("goingOn");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/airlines","root","@Prem2arul");
			
			Statement pst = con.createStatement();
	
			
		    String sql ="select * from flight_timing where DEPART = '"+depart+"' AND DISPRTURE = '"+disprture+"' AND DATE='"+goingOn+"'";
			
			ResultSet rs = pst.executeQuery(sql);
			
			out.println("<hr><br><table cellspacing='0' cellpadding='10' border='1'>");
			out.println("<tr>");
			out.println("<td> id</td>");
			out.println("<td> FLIGHT</td>");
			out.println("<td>DEPART </td>");
			out.println("<td>DISPRTURE </td>");
			out.println("<td>TIME </td>");
			out.println("<td>DATE </td>");
			out.println("<td>BOOK </td>");
			out.println("</tr>");

			while(rs.next()) {
			out.println("<tr>");
			out.println("<td>" +  rs.getInt("id")+"</td>");
			out.println("<td>" +  rs.getString("FLIGHT")+"</td>");
			out.println("<td>" +  rs.getString("DEPART")+"</td>");
			out.println("<td>" +  rs.getString("DISPRTURE")+"</td>");
			out.println("<td>" +  rs.getString("TIME")+"</td>");
			out.println("<td>" +  rs.getString("DATE")+"</td>");
			out.println("<td>" + "<a href='http://localhost:8080/flyaway/Ticket_booking.html'> Book</a>"+"</td>");
			out.println("</tr>");
		
			
			}
			
			out.println("</table");
			
			con.close();
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
