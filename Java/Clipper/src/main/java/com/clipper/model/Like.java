package com.clipper.model;

/**
 * The Like class holds which Users have liked which Posts.
 * 
 * Exists to ensure uniqueness of Likes;
 * One User may Like one Post once.
 * A User cannot place multiple Likes on the same Post.
 * 
 * The Object.equals() method is overridden to further enforce uniqueness
 * when Likes are stored in a Set.
 */
public class Like 
{
	private int likeId;
	
	/**
	 * The Post being liked
	 */
	private Post post;
	
	/**
	 * The User liking the Post
	 */
	private User user;
	
	public Like() {}

	public Like(int likeId, Post post, User user) {
		super();
		this.likeId = likeId;
		this.post = post;
		this.user = user;
	}

	public int getLikeId() {
		return likeId;
	}

	public void setLikeId(int likeId) {
		this.likeId = likeId;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Like [likeId=" + likeId + ", post=" + post + ", user=" + user + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Like other = (Like) obj;
		if (post == null || other.getPost() == null) {
				return false;
		} else if (post.getId() != other.post.getId())
			return false;
		
		if (user == null || other.getUser() == null)
			return false;
		else if (user.getId() != other.user.getId())
			return false;
		
		return true;
	}
}
