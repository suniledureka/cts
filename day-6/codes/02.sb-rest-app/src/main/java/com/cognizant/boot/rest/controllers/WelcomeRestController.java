package com.cognizant.boot.rest.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cts")
public class WelcomeRestController {
	
	@GetMapping(path = "/welcome")
	public String showWelcomeMessageGet() {
		return "Welcome to Cogonizant!! - GET";
	}
	
	@PostMapping(path = "/welcome")
	public String showWelcomeMessagePost() {
		return "Welcome to Cogonizant!! - POST";
	}	
	
	@PutMapping(path = "/welcome")
	public String showWelcomeMessagePut() {
		return "Welcome to Cogonizant!! - PUT";
	}
	
	@DeleteMapping(path = "/welcome")
	public String showWelcomeMessageDelete() {
		return "Welcome to Cogonizant!! - DELETE";
	}
	
	@PatchMapping(path = "/welcome")
	public String showWelcomeMessagePatch() {
		return "Welcome to Cogonizant!! - PATCH - Partial Updation";
	}	
}
