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

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * The PostImage class holds a reference to the image link associated with a post.
 * 
 * This originally referenced more tables;
 * 		it's still its own type due to the legacy build.
 */
@Entity(name="PostImage")
@Table(name="images")
@SequenceGenerator(name="post_image_ids_sequence", initialValue=1)
public class PostImage
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_image_ids_sequence")
	@Column(name="image_id")
	private int id;
	
	@Column(name = "image_link", nullable=false)
	private String imageLink;
	
	/**
	 * Post that the image is associated with
	 */
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "post_id", referencedColumnName = "post_id", nullable=false)
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