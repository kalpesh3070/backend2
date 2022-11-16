package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userImpo {
	
	public static Connection con;

	public static void initDataBase() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			

			con = DriverManager.getConnection("jdbc:mysql://localhost/airlines", "root", "@Prem2arul");
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean signup(user user) {
		try {
			PreparedStatement pst = con.prepareStatement("select * from user where username=? and password=?");
			pst.setString(1, user.getUserName());
			pst.setString(2, user.getPassword());
			ResultSet rs = pst.executeQuery();
			if (rs != null && rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean login (user user) {

		int res = -1;
		try {
			PreparedStatement pst = con.prepareStatement("insert into user(username, password) values (?,?)");
			pst.setString(1, user.getUserName());
			pst.setString(2, user.getPassword());
			res = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return (res == 1) ? true : false;
	}



	


}
