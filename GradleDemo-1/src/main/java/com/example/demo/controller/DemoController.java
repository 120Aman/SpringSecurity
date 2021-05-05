package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
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
