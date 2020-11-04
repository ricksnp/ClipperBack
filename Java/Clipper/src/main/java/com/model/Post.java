package com.model;

public class Post 
{
	int post_id;
	int user_id;
	String content;
	String image_link;
	int like_count;
	
	
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImage_link() {
		return image_link;
	}
	public void setImage_link(String image_link) {
		this.image_link = image_link;
	}
	public int getLike_count() {
		return like_count;
	}
	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}
	
	public Post(int post_id, int user_id, String content, String image_link, int like_count) {
		super();
		this.post_id = post_id;
		this.user_id = user_id;
		this.content = content;
		this.image_link = image_link;
		this.like_count = like_count;
	}
	
	
	
	
}
