package com.model;

public class Like 
{
	int like_id;
	int post_id;
	int user_id;
	
	public int getLike_id() {
		return like_id;
	}
	public void setLike_id(int like_id) {
		this.like_id = like_id;
	}
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
	
	public Like(int like_id, int post_id, int user_id) {
		super();
		this.like_id = like_id;
		this.post_id = post_id;
		this.user_id = user_id;
	}
	
	
}
