package com.cognizant.boot.rest.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cibil")
public class CibilRestController {
	
	@GetMapping("/score/{name}/{pan}")
	public ResponseEntity<?> getCibilScore(@PathVariable("name") String customerName,
										@PathVariable(value = "pan", required = false) String pan){
		if(pan.length() == 10) {
			String response = String.format("Hello %s, your CIBIL Score is 795", customerName);
			return ResponseEntity.ok(response);
		}
		return ResponseEntity.badRequest().body(String.format("%s, you submitted PAN: %s, is NOT Valid", customerName, pan));
	}
}
