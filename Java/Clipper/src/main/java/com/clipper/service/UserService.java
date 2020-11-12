package com.clipper.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clipper.model.User;
import com.clipper.repo.UserDao;

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
	
	public User loginUser(String username) {
		return ud.findUserByUsername(username);
	}
	
	public List<User> getAllUsers(){
		return ud.findAll();
	}
	
	public User updateUser(User u){
		return ud.update(u);
	}
	
	public User getUserByEmail(String email) {
		return ud.findUserByEmail(email);
	}
	
	public User getUserById(int id) {
		return ud.findById(id);
	}
	
}