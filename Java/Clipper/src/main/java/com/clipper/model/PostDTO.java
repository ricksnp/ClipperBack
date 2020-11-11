package com.clipper.model;

public class PostDTO {
	private int user_id;
	private String content;
	
	public PostDTO(int user_id, String content) {
		super();
		this.user_id = user_id;
		this.content = content;
	}
	public PostDTO() {}
	
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

	
	
}
