package main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/signup")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		user user = new user(0,request.getParameter("username"),request.getParameter("password"));
        userImpo userImpl = new userImpo();
		
         userImpl.initDataBase();
		boolean res = userImpl.login(user);
		
		if(res) {
			out.println("<h2>Sign In Successfull !</h2>");
			RequestDispatcher rd = request.getRequestDispatcher("Home.html");
			rd.forward(request, response);
		}
		
		else {
			out.println("<h2>Credentials did not match</h2>");
			RequestDispatcher rd = request.getRequestDispatcher("signin.html");
			rd.include(request, response);
		}

	}

}
