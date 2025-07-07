package com.cognizant.boot.rest.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DateRestController {

	@GetMapping(path = { "/date", "/today" })
	public ResponseEntity<String> generateTodaysDateAndTime() {
		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
		String dateTime = ldt.format(formatter);

		// ResponseEntity<String> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		// ResponseEntity<String> responseEntity = new ResponseEntity<String>(dateTime, HttpStatus.CREATED);
		
		/*
		// ----- include response headers ----
		HttpHeaders respHeaders = new HttpHeaders();

		respHeaders.add("company", "Cognizant");
		respHeaders.add("location", "Hyderabad");
		respHeaders.add("contact", "Manish");
		
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(dateTime, respHeaders, HttpStatus.CREATED);
		*/
		
		//ResponseEntity<String> responseEntity = ResponseEntity.ok(dateTime);
		ResponseEntity<String> responseEntity = ResponseEntity.ok().body(dateTime);
		
		return responseEntity;
	}
}
