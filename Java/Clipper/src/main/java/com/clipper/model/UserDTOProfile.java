package com.clipper.model;

public class UserDTOProfile {
	private int id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String bio;
	private String pfpLink;
	
	public UserDTOProfile(int id, String username, String password, String firstName, String lastName, String email,
			String bio, String pfpLink) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.bio = bio;
		this.pfpLink = pfpLink;
	}
	
	public UserDTOProfile() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getPfpLink() {
		return pfpLink;
	}

	public void setPfpLink(String pfpLink) {
		this.pfpLink = pfpLink;
	}
	
	
	
	
}
