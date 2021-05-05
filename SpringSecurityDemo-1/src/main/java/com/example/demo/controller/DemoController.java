package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@RestController
public class DemoController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@PostMapping("/add")
	public String addUser(@RequestBody User user) {
		User newUser =new User();
		newUser.setId(user.getId());
		newUser.setUsername(user.getUsername());
		newUser.setPassword(passwordEncoder.encode(user.getPassword()));
		newUser.setRoles(user.getRoles());
		userRepository.save(newUser);
		return "user added successfully";
	}
	
	@GetMapping("/")
	public String getString() {
		return "Hello World";
	}
	
	@GetMapping("/user")
	public String User() {
		return "Hello User";
	}
	@GetMapping("/admin")
	public String Admin() {
		return "Hello Admin";
	}
}
