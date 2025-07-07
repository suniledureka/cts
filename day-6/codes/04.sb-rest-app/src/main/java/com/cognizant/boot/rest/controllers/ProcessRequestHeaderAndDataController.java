package com.cognizant.boot.rest.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProcessRequestHeaderAndDataController {
	
	@PostMapping("/data")
	public ResponseEntity<?> processRequestHeadersAndData(@RequestHeader("Host") String host, 
													      @RequestHeader(value = "company", required = false, defaultValue = "NA") String company,
													      @RequestBody(required = false) String reqBody){
		
		String response = String.format("Host: %s\nCompany: %s\nBody: %s", host, company, reqBody);
		
		ResponseEntity<String> respEntity = ResponseEntity.ok().body(response);
		return respEntity;
	}
}
