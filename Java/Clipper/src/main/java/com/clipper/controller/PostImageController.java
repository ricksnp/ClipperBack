package com.clipper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clipper.dto.PostImageDTO;
import com.clipper.model.PostImage;
import com.clipper.service.PostImageService;
import com.clipper.service.PostService;

@Controller
@CrossOrigin
public class PostImageController {
	
	
	private PostImageService is;
	
	@Autowired
	private PostService ps;

	public PostImageService getIs() {
		return is;
	}
	
	@Autowired
	public void setIs(PostImageService is) {
		this.is = is;
	}
	
	/**
	 * Add a image to a post.
	 * @return The added image
	 */
	@PostMapping("/addImage.json")
	public @ResponseBody PostImage addImage(@RequestBody PostImageDTO pid){
		return is.addPostImage(new PostImage(0, pid.getImage_link(), ps.findById(pid.getPost_id())));
	}

}
