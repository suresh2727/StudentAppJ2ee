package com.studentapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.studentapp.connector.Connector;
import com.studentapp.dto.Student;



public class StudentDao {
	 public static boolean insertStudent(Student s) 
	 {
		 
		 Connection con = null;
		 PreparedStatement ps = null;
		 String query = "INSERT INTO STUDENT_TABLE VALUES(?,?,?,?,?,?,?)";
		 int res=0;
		 try {
			con=Connector.requestConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, s.getSid());
			ps.setString(2, s.getName());
			ps.setLong(3, s.getPhone());
			ps.setString(4, s.getMail());
			ps.setString(5, s.getBranch());  
			ps.setString(6, s.getLocation());
			ps.setString(7, s.getPassword());
			res = ps.executeUpdate();
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		 
		 if(res>0) {
			 return true;
		 }
		 else {
			 return false;
			 
		 }
		 
		 
		 
		
		 
	 }
	 
	 
	 public static Student getStudent(int sid,String password) 
	 
	 {
		 Connection con = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 Student s=null;
		 String query = "select * from STUDENT_TABLE where sid=? and password=?";
		 
		 try {
			 con=Connector.requestConnection();
			 ps = con.prepareStatement(query);
			 ps.setInt(1, sid);
			 ps.setString(2, password);
			 
			 rs=ps.executeQuery();
			 if(rs.next()) {
				 s=new Student();
				 s.setSid(rs.getInt(1));
				 s.setName(rs.getString(2));
				 s.setPhone(rs.getLong(3));
				 s.setMail(rs.getString(4));
				 s.setBranch(rs.getString(5));
				 s.setLocation(rs.getString(6));
				 s.setPassword(rs.getString(7));
				 
				 
			 }
			 
			 
			 
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return s;
		
		 
		 
		 
	 }
	 
	 
	 public static List getStud() {
		
		 Connection con = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 Student s=null;
		 String query = "select * from STUDENT_TABLE";
		 List<Student> lst = new ArrayList<>();
		 
		 
		 try {
			con=Connector.requestConnection();
			ps = con.prepareStatement(query);
			 rs=ps.executeQuery();
			 while(rs.next()) {
				 s=new Student();
				 s.setSid(rs.getInt(1));
				 s.setName(rs.getString(2));
				 s.setPhone(rs.getLong(3));
				 s.setMail(rs.getString(4));
				 s.setBranch(rs.getString(5));
				 s.setLocation(rs.getString(6));
				 s.setPassword(rs.getString(7));
				 
				 lst.add(s);
			 }
			 
			
			
			
			 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		 
		return lst;
		 
	 }
	 
	 
	 
	 public static boolean DeleteStudent(int sid) {
		 
		 Connection con = null;
		 PreparedStatement ps = null;
		 String query = "delete from student_table where sid=?";
		 
		 int res = 0;
		 try {
			con=Connector.requestConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, sid);
			res = ps.executeUpdate();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if(res>0){
			return true;
		}
		else {
			return false;
		}
		
		 
	 }	 
}
