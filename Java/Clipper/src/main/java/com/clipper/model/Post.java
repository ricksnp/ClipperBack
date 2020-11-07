package com.clipper.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;

/**
 * The Post class holds all content associated with a Clipper post.
 */
@Entity
public class Post 
{
	private int id;
	private String textContent;
	
	/**
	 * The parent User
	 */
	private User user;
	
	/**
	 * All images associated with a post.
	 */
	private List<PostImage> images;
	
	/**
	 * All likes associated with a post.
	 */
	private Set<Like> likes;
	
	public Post() {}

	public Post(int id, String textContent, User user, List<PostImage> images, Set<Like> likes) {
		super();
		this.id = id;
		this.user = user;
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

	public List<PostImage> getImages() {
		return images;
	}

	public void setImages(List<PostImage> images) {
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
