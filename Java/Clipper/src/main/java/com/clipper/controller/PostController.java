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
		ApplicationContext ac = new ClassPathXmlApplicationContext("config.xml");

		UserDao dao = ac.getBean(UserDao.class);
		PostDao pdao = ac.getBean(PostDao.class);
		
		
		dao.save(new User(0, "nathan1", "AAA", "Nathan", "Ricks", "ricks@gmail.com", "lol bio", "pfp link", null, null));
		dao.save(new User(0, "user2", "password", "User", "Name", "user@nothing.net", "biography", "profile pic", null, null));
		
		pdao.save(new Post(0, "Hello World", dao.findById(2), null, null));
		
		System.out.println(dao.delete(1));
		
		System.out.println(dao.findAll());
		
		System.out.println(pdao.findAll());
		System.out.println("Success!");
		
		return dao.findAll();
	}

}