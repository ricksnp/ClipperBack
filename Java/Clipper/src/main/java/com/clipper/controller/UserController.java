package com.clipper.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clipper.model.User;
import com.clipper.service.UserService;

@Controller
@CrossOrigin
public class UserController {

	private UserService us;

	public UserService getPps() {
		return us;
	}

	@Autowired
	public void setPps(UserService us) {
		this.us = us;
	}
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST, value="/registerUser.json")
	public @ResponseBody User registerUser(@RequestBody User u) {
		return us.registerUser(u);
	}
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST, value="/login.json")
	public @ResponseBody User userLogin(@RequestBody  User u) {
		
		String username = u.getUsername();
		String password = u.getPassword();
		
		
		User temp = us.loginUser(username);
		System.out.println(temp);
		
		if (temp != null) {
			if (temp.getPassword().equals(password)) {
				return temp;
			}
		}
		return null;
		
		
	}

}