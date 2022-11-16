package main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out =response.getWriter();
		
		response.setContentType("text/html");
		
        user user = new user(0,request.getParameter("username"),request.getParameter("password"));
        userImpo userImpl = new userImpo();
		
         userImpl.initDataBase();
		boolean res = userImpl.signup(user);
		
		if (res) {
			RequestDispatcher rd = request.getRequestDispatcher("Home.html");
			
		}

		else {
			out.println("<h2>There was some error, please try again</h2>");
			RequestDispatcher rd = request.getRequestDispatcher("signup.html");
			rd.include(request, response);
		}

	}

}
