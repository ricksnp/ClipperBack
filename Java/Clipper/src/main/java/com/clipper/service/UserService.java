package com.clipper.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clipper.model.User;
import com.clipper.dao.UserDao;

@Service
public class UserService {

	private UserDao ud;

	public UserDao getUd() {
		return ud;
	}

	@Autowired
	public void setUd(UserDao ud) {
		this.ud = ud;
	}
	
	public User registerUser(User u){
		return ud.save(u);
	}
	
}