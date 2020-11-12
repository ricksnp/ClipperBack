package com.clipper.dto;

public class UserDTOEmail {
	
	private String email;

	public UserDTOEmail(String email) {
		super();
		this.email = email;
	}
	
	public UserDTOEmail() {}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
