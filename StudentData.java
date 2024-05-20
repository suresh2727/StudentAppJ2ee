package com.ps.app1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class StudentData {
	public static void main(String[] args) {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/StudentApp";
		String user = "root";
		String password = "tiger";
		Statement smt = null;
		String query = "select * from student_table";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection(url, user, password);
			 smt = con.createStatement();
			 ResultSet rs = smt.executeQuery(query);
			 while(rs.next()) {
				 System.out.println("SID: "+rs.getInt(1));
				 System.out.println("NAME: "+rs.getString(2));
				 System.out.println("PHONE: "+rs.getLong(3));
				 System.out.println("MAIL: "+rs.getString(4));
				 System.out.println("BRANCH: " +rs.getString(5));
				 System.out.println("LOCATION: " +rs.getString(6));
				 System.out.println("PASSWORD: " + rs.getString(7)); 
				 System.out.println("--------------------------------------");
			 }
			 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace(); 
		}
		
		
	}
}
