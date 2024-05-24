package com.studentapp.dto;

public class Student {
	private int sid;
	private String	name;
	private long phone;
	private String mail;
	private String branch;
	private String location;
	private String password;
	
	
	public Student(int sid, String name, long phone, String mail, String branch, String location, String password) {
		this.sid = sid;
		this.name = name;
		this.phone = phone;
		this.mail = mail;
		this.branch = branch;
		this.location = location;
		this.password = password;
		
		
	}
	
	public Student() {
		super();
	}

	public void setSid(int sid) {
		this.sid = sid;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setPhone(long phone) {
		this.phone = phone;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public void setBranch(String branch) {
		this.branch = branch;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getSid() {
		return sid;
	}
	public String getName() {
		return name;
	}
	public long getPhone() {
		return phone;
	}
	public String getMail() {
		return mail;
	}
	public String getBranch() {
		return branch;
	}
	public String getLocation() {
		return location;
	}
	public String getPassword() {
		return password;
	}
	
	
	@Override
	public String toString() {
		
		return this.sid + " "+this.name + " " + this.phone + " " + this.mail + " " + this.branch + " " + this.location + " " + this.password + " "; 
	}
	
	
	
	
	
	
	
	
}
