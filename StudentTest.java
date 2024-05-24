package com.studentapp.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.studentapp.dao.StudentDao;
import com.studentapp.dto.Student;
 
public class StudentTest {
	public static void main(String[] args) {
		
		StudentDao sdao = new StudentDao();
		Scanner sc = new Scanner(System.in);
		
		Student s=null;
		while(true) {
			System.out.println("--------------------------STUDENT-DATABASE--------------------------------");
			int ch=0;
			System.out.println("Welcome to Student Database");
			System.out.println("1. Insert Student Data\n2. Login\n3. Update Data\n4. All Student Data\n5. Delete Data\n6. Exit");
			ch=sc.nextInt();
			switch (ch) {
			case 1:	System.out.println("---------------STUDENT REG---------------------------");
					System.out.println("Enter SID for a Student");
					int sid  = sc.nextInt();
					System.out.println("Enter Name for a student");
					String name = sc.next();
					System.out.println("Enter the phone number of a student");
					long phone = sc.nextLong();
					System.out.println("Enter mail ID of student");
					String mail = sc.next();
					System.out.println("Enter branch of Student");
					String branch = sc.next();
					System.out.println("Enter the location");
					String location = sc.next();
					System.out.println("Enter  the password");
					String password = sc.next();
					System.out.println("Confirm the password");
					String confirm = sc.next();
			
					if(password.equals(confirm)) {
						 s = new Student(sid, name, phone, mail, branch, location, password);
						boolean res = sdao.insertStudent(s);
						System.out.println("Data Saved");
					}
					else {
						System.out.println("Password MisMatch");
					}
				break;
				
				
			case 2: System.out.println("------------------Login Student-------------------");
					System.out.println("Enter sid for login");
					int sidl =sc.nextInt();
					System.out.println("Enter password to login");
					String passwordl = sc.next();
					System.out.println("--------------------Details of Student are---------");
					s=sdao.getStudent(sidl, passwordl);
					if(s!=null) {
						System.out.println(s);
						
					}
					else {
						System.out.println("Incorrect id or password");
					}
			 
					break;
			
			
			case 3: System.out.println("----------Update Student data--------------------");
					int c=0;
					System.out.println("Enter the choice to update the field");
					System.out.println("1. Name\n2. Phone\n3. Mail\n4. Branch\n5. Location\n6. Password");
					c=sc.nextInt();
					System.out.println("Enter the Sid to make the Changes");
					int id = sc.nextInt();
					Student s1=null;
					boolean res=false;
					switch (c) {
					case 1: System.out.println("Enter the Updated Name");
							s1= sdao.getStudent(id);
							String uname = sc.next();
							 
							
							s1.setName(uname);
							s1.setSid(id);
							
							res = sdao.UpdateData(s1);
							if(res) {
								System.out.println("Name Changed Successfully");
							}
							else {
								System.out.println("Name Not Changed");
							}
						    break;
						    
					case 2: System.out.println("Enter the Updated Phone Number");
							long uphone = sc.nextLong();
							s1=sdao.getStudent(id);
							s1.setPhone(uphone);
							s1.setSid(id);
							res = sdao.UpdateData(s1);
							if(res) {
								System.out.println("Phone Number Changed Successfully");
							}
							else {
								System.out.println("Phone Number Not Changed");
							}
							
							break;
							
							
					case 3: System.out.println("Enter the Updated Mail Id");
							String umail= sc.next();
							s1=sdao.getStudent(id);
							
							s1.setMail(umail);
							s1.setSid(id);
							
							res = sdao.UpdateData(s1);
							if(res) {
								System.out.println("Mail id Changed Successfully");
							}
							else {
								System.out.println("Mail id Not Changed");
							}
							
							break;
							
							
					case 4: System.out.println("Enter the Updated Branch");
							String ubranch = sc.next();
							s1=sdao.getStudent(id);
							
							s1.setBranch(ubranch);
							s1.setSid(id);
							
							
							res = sdao.UpdateData(s1);
							if(res) {
								System.out.println("Branch Changed Successfully");
							}
							else {
								System.out.println("Branch Not Changed");
							}
							
							
							break;
							
					case 5: System.out.println("Enter the Updated Location");
					        String ulocation = sc.next();
					    	s1=sdao.getStudent(id);
					    	
					        s1.setLocation(ulocation);
					        s1.setSid(id);
					        
					        res = sdao.UpdateData(s1);
							if(res) {
								System.out.println("Location Changed Successfully");
							}
							else {
								System.out.println("Location Not Changed");
							}
							
					        
					        break;
					        
					case 6: System.out.println("Enter New Password");
					        String uPassword = sc.next();
					    	s1=sdao.getStudent(id);
					    	
					    	s1.setPassword(uPassword);
					    	s1.setSid(id);
					        res = sdao.UpdateData(s1);
							if(res) {
								System.out.println("Password Changed Successfully");
							}
							else {
								System.out.println("Password Not Changed");
							}
							
					        
					        break;
							
					default: System.out.println("Invalid Choice");
						     break;
					}
					
					break;
					
			case 4: System.out.println("-----------------Student Data---------------");

					List<Student> ls = sdao.getStud();
					for (Student student : ls) {
						System.out.println(student);
						System.out.println("----------------------------------------------------------------------------");
					}
					break;
					
			case 5: System.out.println("----------------------Delete Student data--------------------");
					System.out.println("Enter the sid to delete a student data");
					int sid1 = sc.nextInt();
					res = sdao.DeleteStudent(sid1);
					if(res==true) {
						System.out.println(" Deleted Data sucessfully");
					}
					else {
						System.out.println("Data not delete");
					}
					
					break;
					
			case 6: System.out.println("--------------Thank you For using Student Database---------------------");
					System.exit(0);
					break;

			default: System.out.println("Invalid Choice");
					break;
		}
		
		}
	}
}