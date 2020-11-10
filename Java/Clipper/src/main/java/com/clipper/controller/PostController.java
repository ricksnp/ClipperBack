package com.clipper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clipper.model.Post;
import com.clipper.service.PostService;

@Controller
@CrossOrigin
public class PostController {

	private PostService ps;

	public PostService getPps() {
		return ps;
	}

	@Autowired
	public void setPps(PostService ps) {
		this.ps = ps;
	}
	
	/**
	 * Retrieve a list of all posts in the system.
	 * @return The list of all posts
	 */
	@GetMapping("/allPosts.json")
	public @ResponseBody List<Post> getAllPosts(){
		return ps.findAll();
	}
	
	/**
	 * Retrieve a JSON representation of a single post based on the ID.
	 * @param id The ID of the post.
	 * @return The post object
	 */
	@GetMapping("/post/{id}.json")
	public @ResponseBody Post getPost(@PathVariable Integer id) {
		return ps.findById(id);
	}
	
	/**
	 * Delete a specific post.
	 * @param id The id of the post to be deleted
	 * @return The deleted post
	 */
	@DeleteMapping("/post/{id}.json")
	public @ResponseBody Post deletePost(@PathVariable Integer id) {
		return ps.deletePost(id);
	}
	
	/**
	 * Retrieve a certain user's posts.
	 * @param id The ID of the user.
	 * @return The list of posts
	 */
	@GetMapping("/user/{id}/posts.json")
	public @ResponseBody List<Post> getPostsByUser(@PathVariable Integer id) {
		return ps.findAllPostByUserId(id);
	}
	
	/**
	 * Update a user's specific post.
	 * @param p The post
	 * @param id The user's id
	 * @param pId The post id
	 * @return The modified post
	 */
	@PutMapping("/user/{id}/posts/{pId}.json")
	public @ResponseBody Post updatePost(@RequestBody Post p, @PathVariable Integer id, @PathVariable Integer pId) {
		return ps.updatePost(p);
	}
	
	

}