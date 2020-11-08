package com.clipper.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
@Entity(name="Like")
@Table(name="likes")
@SequenceGenerator(name="like_ids_sequence", initialValue=1)
public class Like 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "like_ids_sequence")
	@Column(name="like_id")
	private int likeId;
	
	/**
	 * The Post being liked
	 */
	@ManyToOne
	@JoinColumn(name = "post_id", referencedColumnName = "post_id", nullable=false)
	private Post post;
	
	/**
	 * The User liking the Post
	 */
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable=false)
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
		return "Like [likeId=" + likeId + ", post=" + "[a post]" + ", user=" + "[a user]" + "]";
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