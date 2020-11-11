package com.clipper.model;

public class PostImageDTO {
	private int post_id;
	private String image_link;
	
	
	public PostImageDTO(int post_id, String image_link) {
		super();
		this.post_id = post_id;
		this.image_link = image_link;
	}
	public PostImageDTO() {}
	
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getImage_link() {
		return image_link;
	}
	public void setImage_link(String image_link) {
		this.image_link = image_link;
	}
	
	
}
