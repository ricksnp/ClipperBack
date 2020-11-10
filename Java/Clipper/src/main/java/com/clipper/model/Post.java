package com.clipper.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * The Post class holds all content associated with a Clipper post.
 */
@Entity(name="Post")
@Table(name="posts")
@SequenceGenerator(name="user_ids_sequence", initialValue=1)
public class Post 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_ids_sequence")
	@Column(name="post_id")
	private int id;
	
	@Column(name="content")
	private String textContent;
	
	/**
	 * The parent User
	 */
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable=false)
	private User user;
	
	/**
	 * All images associated with a post.
	 */
	@JsonManagedReference
	@OneToMany(mappedBy="id")
	private Set<PostImage> images;
	
	/**
	 * All likes associated with a post.
	 */
	@JsonManagedReference
	@OneToMany(mappedBy="likeId")
	private Set<Like> likes;
	
	public Post() {}

	public Post(int id, String textContent, User user, Set<PostImage> images, Set<Like> likes) {
		super();
		this.id = id;
		//this.user = user;
		this.textContent = textContent;
		this.images = images;
		this.likes = likes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTextContent() {
		return textContent;
	}

	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}

	public Set<PostImage> getImages() {
		return images;
	}

	public void setImages(Set<PostImage> images) {
		this.images = images;
	}

	public Set<Like> getLikes() {
		return likes;
	}

	public void setLikes(Set<Like> likes) {
		this.likes = likes;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", user=" + "[a user]" + ", textContent=" + textContent + ", images=" + "[images]"
				+ ", likes=" + "[lots of likes]" + "]";
	}
	
}