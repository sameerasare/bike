package com.practice.user.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.practice.user.models.User;
import com.practice.user.repositories.UserRepository;

//@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("users")
public class UserControllers {
	
	@Autowired
	private UserRepository userRepository;

	@CrossOrigin
	@GetMapping
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	@CrossOrigin
	@PostMapping("/new")
	@ResponseStatus(HttpStatus.OK)
	public void createUser(@RequestBody User user) {
		userRepository.save(user);
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public User get(@PathVariable("id") long id) {
		return userRepository.getOne(id);
				
	}
	
	@CrossOrigin
	@DeleteMapping(path = {"/{id}"})
	public User deleteUser(@PathVariable("id") long id) {
		User user = userRepository.getOne(id);
		userRepository.deleteById(id);
		return user;
	}
}
