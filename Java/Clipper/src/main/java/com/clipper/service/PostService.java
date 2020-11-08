package com.clipper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clipper.model.Post;
import com.clipper.dao.PostDao;

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
	
}