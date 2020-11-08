package com.clipper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.clipper.dao.UserDao;
import com.clipper.model.User;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("config.xml");
		
		
		UserDao dao = ac.getBean(UserDao.class);
		
		dao.save(new User(0, "nathan1", "AAA", "Nathan", "Ricks", "ricks@gmail.com", "lol bio", "pfp link", null, null));
		dao.save(new User(0, "user2", "password", "User", "Name", "user@nothing.net", "biography", "profile pic", null, null));
		
		User u = dao.delete(1);
		
		System.out.println(u);
		
		System.out.println(dao.findAll());
		
		
	}

	
}
