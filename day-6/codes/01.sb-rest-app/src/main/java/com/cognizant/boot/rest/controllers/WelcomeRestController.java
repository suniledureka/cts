package com.cognizant.boot.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {
	
	//@RequestMapping("/welcome")	
	//@RequestMapping(value = "/welcome")
	//@RequestMapping(path = "/welcome")
	//@RequestMapping(path = "/welcome", method = RequestMethod.GET)
	//@GetMapping("/welcome")
	//@GetMapping(path = "/welcome")
	@GetMapping(value = "/welcome")
	public String showWelcomeMessage() {
		return "Welcome to Cogonizant!!";
	}
}
