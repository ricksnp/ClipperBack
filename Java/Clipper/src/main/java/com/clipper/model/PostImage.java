package com.clipper.model;

/**
 * The PostImage class holds a reference to the image link associated with a post.
 * 
 * This originally referenced more tables;
 * 		it's still its own type due to the legacy build.
 */
public class PostImage
{
	private int id;
	private String imageLink;
	
	/**
	 * Post that the image is associated with
	 */
	private Post post;
	
	public PostImage() { }
	public PostImage(int id, String imageLink, Post post) {
		super();
		this.id = id;
		this.imageLink = imageLink;
		this.post = post;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	
	@Override
	public String toString() {
		return "PostImage [id=" + id + ", imageLink=" + imageLink + ", post=" + "[a post]" + "]";
	}
}
