package com.clipper.dto;


public class PostDTO {
	private int user_id;
	private String content;
	private String linkOfPic;
	
	public PostDTO(int user_id, String content, String linkOfPic) {
		super();
		this.user_id = user_id;
		this.content = content;
		this.linkOfPic = linkOfPic;
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

	public void setContent(String linkOfPic) {
		this.linkOfPic = content;
	}

	public String getLinkOfPic() {
		return linkOfPic;
	}

	public void setLinkOfPic(String linkOfPic) {
		this.linkOfPic = linkOfPic;
	}
	
	
	
	
}
