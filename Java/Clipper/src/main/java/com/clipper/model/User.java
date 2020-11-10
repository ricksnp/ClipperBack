package com.clipper.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * The User class holds all information tied to a particular Clipper user.
 */

@Entity(name="User")
@Table(name="users")
@SequenceGenerator(name="user_ids_sequence", initialValue=1)
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_ids_sequence")
	@Column(name="user_id")
	private int id;
	
	@Column(name="username", nullable=false, unique=true)
	private String username;
	
	@Column(name="password", nullable=false)
	private String password;
	
	@Column(name="first_name", nullable=false)
	private String firstName;
	
	@Column(name="last_name", nullable=false)
	private String lastName;
	
//	@Email // javax.validation.constraints.Email
	@Column(name="email", nullable=false, unique=true)
	private String email;
	
	@Column(name="biography")
	private String bio;
	
	/**
	 * The pfpLink is a link to the user's profile picture.
	 */
	@Column(name="pfp_link", nullable=false, columnDefinition="varchar default 'https://i.pinimg.com/474x/50/5f/ae/505fae07cccb7098f7e82c82f857b13a.jpg'")
	private String pfpLink;
	
	/**
	 * All posts associated made by the User will be tracked here.
	 */
	@JsonManagedReference
	@OneToMany(mappedBy="user")
	private List<Post> posts;
	
	/**
	 * All likes made by the User will be tracked here.
	 */
	@JsonManagedReference
	@OneToMany(mappedBy="user")
	private Set<Like> likes;
	
	public User() {}
	public User(int id, String username, String password, String firstName, String lastName, String email, String bio,
			String pfpLink, /*List<Post> posts,*/ Set<Like> likes) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.bio = bio;
		this.pfpLink = pfpLink;
		//this.posts = posts;
		this.likes = likes;
	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	

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
//	public List<Post> getPosts() {
//		return posts;
//	}
//	public void setPosts(List<Post> posts) {
//		this.posts = posts;
//	}
	public Set<Like> getLikes() {
		return likes;
	}
	public void setLikes(Set<Like> likes) {
		this.likes = likes;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", bio=" + bio + ", pfpLink=" + pfpLink + ", posts="
				+ "[lots of posts]" + ", likes=" + "[lots of likes]" + "]";
	}
}