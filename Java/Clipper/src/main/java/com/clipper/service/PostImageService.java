package com.clipper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clipper.model.PostImage;
import com.clipper.repo.PostImageDao;

@Service
public class PostImageService {
	
	private PostImageDao pid;

	public PostImageDao getPid() {
		return pid;
	}

	@Autowired
	public void setPid(PostImageDao pid) {
		this.pid = pid;
	}
	
	public PostImage addPostImage(PostImage pi) {
		return pid.save(pi);
	}

}
