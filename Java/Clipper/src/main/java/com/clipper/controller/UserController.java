package com.clipper.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clipper.model.User;
import com.clipper.model.UserDTO;
import com.clipper.model.UserDTOEmail;
import com.clipper.model.UserDTOProfile;
import com.clipper.service.UserService;
import com.clipper.util.Utilities;


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
	
	/**
	 * Add a new user into the system, but first hashing his/her password.
	 * @param u The user to be inserted
	 * @return The inserted user
	 */
	@PostMapping("/registerUser.json")
	public @ResponseBody User registerUser(@RequestBody UserDTOProfile u) {
		System.out.println("In there");
		u.setPassword(Utilities.hashPassword(u.getPassword()));
		return us.registerUser(new User(0, u.getUsername(), u.getPassword(), u.getFirstName(), u.getLastName(), u.getEmail(), u.getBio(), u.getPfpLink(), null, null));
	}
	
	/**
	 * Login an existing user into the system.
	 * @param u The user that will log in
	 * @return The logged in user
	 */
	@PostMapping("/login.json")
	public @ResponseBody User userLogin(@RequestBody UserDTO dt) {
		String username = dt.getUsername();
		String password = Utilities.hashPassword(dt.getPassword());
		
		User temp = us.loginUser(username);
		
		if (temp != null) {
			if (temp.getPassword().equals(password)) {
				return temp;
			}
		}
		return null;
	}
	
	/**
	 * Retrieve a list of all the users in the system.
	 * @return The list of all Users.
	 */
	@GetMapping("/allUsers.json")
	public @ResponseBody List<User> getAllUsers(){
		return us.getAllUsers();
	}
	
	/**
	 * Retrieve a JSON representation of a single user based on the ID.
	 * @param id The ID of the user.
	 * @return The user object
	 */
	@GetMapping("/user/{id}.json")
	public @ResponseBody User getUser(@PathVariable Integer id)  {
		try {
			User u = us.getUserById(id);
			if (u != null) {
				return u;
			}
		}
		catch(IndexOutOfBoundsException e) {
			System.out.println("User not found.");
		}
		return null;
	}
	
	/**
	 * Reset a user's password.
	 * @param dt The user to be updated
	 * @return The newly updated user
	 */
	@PostMapping("/resetPass.json")
	public  @ResponseBody User resetPass(@RequestBody UserDTOEmail dte) {
		String newPass = Utilities.getSaltString();
		String hashed = Utilities.hashPassword(newPass);
		
		//TO-DO: Send Email w/ generated password
		Utilities.sendEmail(dte.getEmail(), newPass);
		User temp = us.getUserByEmail(dte.getEmail());
		temp.setPassword(hashed);
		us.updateUser(temp);
		return temp;
	}
	
	/**
	 * Update a user's info.  If the password was changed, we need to re-encrypt it.
	 * @param u The user to be updated
	 * @return The updated user
	 */
	@PostMapping("/updateInfo.json")
	public @ResponseBody User updateUser(@RequestBody UserDTOProfile udp){
		
		User temp = us.getUserById(udp.getId());
		if (temp != null) {
			if (!temp.getPassword().equals(Utilities.hashPassword(udp.getPassword()))) {
				temp.setPassword(Utilities.hashPassword(udp.getPassword()));
			}
			temp.setUsername(udp.getUsername());
			temp.setEmail(udp.getEmail());
			temp.setFirstName(udp.getFirstName());
			temp.setLastName(udp.getLastName());
			temp.setBio(udp.getBio());
			temp.setPfpLink(udp.getPfpLink());
			us.updateUser(temp);
			return temp;
		}
		return null;
	}
	
	
	

}