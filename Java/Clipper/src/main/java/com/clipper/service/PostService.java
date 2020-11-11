package com.clipper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clipper.dao.PostDao;
import com.clipper.model.Post;

@Service
public class PostService {

	private PostDao pd;

	public PostDao getPd() {
		return pd;
	}

	@Autowired
	public void setPd(PostDao pd) {
		this.pd = pd;
	}
	
	public List<Post> findAll(){
		return pd.findAll();
	}
	
	public Post findById(int id) {
		return pd.findById(id);
	}
	
	public Post updatePost(Post t) {
		return pd.update(t);
	}
	
	public Post createPost(Post t) {
		return pd.save(t);
	}
	
	public Post deletePost(int id) {
		return pd.delete(id);
	}
	
	public List<Post> findAllPostByUserId(int id){
		return pd.findAllByUserId(id);
	}
}