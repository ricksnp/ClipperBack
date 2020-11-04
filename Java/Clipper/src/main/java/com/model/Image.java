package com.model;

public class Image 
{
	
	int image_id;
	String image_link;
	int user_id;
	int post_id;
	
	public Image(int image_id, String image_link, int user_id, int post_id) {
		super();
		this.image_id = image_id;
		this.image_link = image_link;
		this.user_id = user_id;
		this.post_id = post_id;
	}
	
	public int getImage_id() {
		return image_id;
	}
	public void setImage_id(int image_id) {
		this.image_id = image_id;
	}
	public String getImage_link() {
		return image_link;
	}
	public void setImage_link(String image_link) {
		this.image_link = image_link;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	
	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}
}
