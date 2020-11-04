package com.model;


public class User 
{
	int user_id;
	String username;
	String password;
	String first_name;
	String last_name;
	String email;
	String pfp_link;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPfp_link() {
		return pfp_link;
	}
	public void setPfp_link(String pfp_link) {
		this.pfp_link = pfp_link;
	}
	
	public User(int user_id, String username, String password, String first_name, String last_name, String email,
			String pfp_link) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.pfp_link = pfp_link;
	}
	
	
	
	
}
