package com.clipper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clipper.dao.PostDao;
import com.clipper.dao.UserDao;
import com.clipper.model.Post;
import com.clipper.model.User;
import com.clipper.service.PostService;

@Controller
@CrossOrigin
@RequestMapping("/posts.json")
public class PostController {

	private PostService ps;

	public PostService getPps() {
		return ps;
	}

	@Autowired
	public void setPps(PostService ps) {
		this.ps = ps;
	}

	@GetMapping
	public @ResponseBody List<User> getAll() {
		return null;
	}

}