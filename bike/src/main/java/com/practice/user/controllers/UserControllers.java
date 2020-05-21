package com.practice.user.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.practice.user.models.User;
import com.practice.user.repositories.UserRepository;

@RestController
@RequestMapping("users")
public class UserControllers {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody User bike) {
		userRepository.save(bike);
	}
	
	@GetMapping("/{id}")
	public User get(@PathVariable("id") long id) {
		return userRepository.getOne(id);
				
	}
}
