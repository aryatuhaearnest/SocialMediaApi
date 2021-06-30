package com.earnest.socialmedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.earnest.socialmedia.model.User;
import com.earnest.socialmedia.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@GetMapping("/users/{id}")
	public User getById(@PathVariable("id") int id) {
		
		return userService.getById(id);
	}
	
	@GetMapping("/users")
	public List<User> getUser() {
		return userService.getUsers();
	}
	
	@DeleteMapping("/users")
	public void deleteUser(@RequestBody User user) {
		userService.deleteUser(user);
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable("id") int id) {
		 userService.deleteUserById(id);
	}
	
	@PutMapping("/users/{id}")
	public User updateUserById(@PathVariable("id") int id , @RequestBody User user )  {
			return userService.updateUserById(id, user);
	}
	
	@PutMapping("/users")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
}
