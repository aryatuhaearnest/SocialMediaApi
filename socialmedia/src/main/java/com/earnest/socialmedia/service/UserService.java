package com.earnest.socialmedia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.earnest.socialmedia.model.Location;
import com.earnest.socialmedia.model.User;
import com.earnest.socialmedia.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User createUser(User user) {
	
		return userRepository.save(user);
	}
	
	public User getById(int id) {
		Optional<User> userOp = userRepository.findById(id);
	  
			if(userOp.isPresent()) {
				return userOp.get();
			}
		return null;
	}
	
	
	public List<User> getUsers() {
	Iterable<User> ui = 	userRepository.findAll();
	List<User> users = new ArrayList<User>();
	ui.forEach( (user) -> users.add(user) );
	
		return users;
	}
	
	public void deleteUser(User user) {
		if(user != null)
		userRepository.delete(user);
	}
	
	public void deleteUserById(int id) {
		userRepository.deleteById(id);
	}
	
	public User updateUserById(int id, User user) {
		User userToUpdate =  userRepository.findById(id).get();
		
		if(userToUpdate != null) {
			userToUpdate.setFirstName(user.getFirstName());
			userToUpdate.setLastName(user.getLastName());
			userToUpdate.setEmail(user.getEmail());
			userToUpdate.setLocation(user.getLocation());
			
			userToUpdate = userRepository.save(userToUpdate);
		}
		return userToUpdate;
	}
	
	public User updateUser(User user) {
User userToUpdate =  userRepository.findById(user.getId()).get();
		
		if(userToUpdate != null) {
			userToUpdate.setFirstName(user.getFirstName());
			userToUpdate.setLastName(user.getLastName());
			userToUpdate.setEmail(user.getEmail());
			userToUpdate.setLocation(user.getLocation());
			
			userToUpdate = userRepository.save(userToUpdate);
		}
		return userToUpdate;
	}
	
}
