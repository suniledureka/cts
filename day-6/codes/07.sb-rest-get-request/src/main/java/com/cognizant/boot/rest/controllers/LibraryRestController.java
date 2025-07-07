package com.cognizant.boot.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.boot.rest.models.Book;
import com.cognizant.boot.rest.services.LibraryServices;

@RestController
@RequestMapping("/library")
public class LibraryRestController {
	
	private LibraryServices libraryService;
	
	@Autowired
	public LibraryRestController(LibraryServices libraryService) {
		super();
		this.libraryService = libraryService;
	}


	@GetMapping(path = "/search/{bid}",
				produces = {"application/json", "application/xml"})
	public ResponseEntity<?> getBookById(@PathVariable("bid") Integer bid) {
		Book book = libraryService.findBookById(bid);
		if(book != null)
			return ResponseEntity.ok().body(book);
		return ResponseEntity.badRequest().body("no matching book for Bid:"+bid+" in Library");
	}
	
	@GetMapping(path = "/all")
	public ResponseEntity<?> getAllBooks() {
		List<Book> books = libraryService.findAll();
		return ResponseEntity.ok().body(books);		
	}
}
