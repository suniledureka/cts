package com.cognizant.boot.rest.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.boot.rest.models.Book;
import com.cognizant.boot.rest.repository.LibraryRepository;
import com.cognizant.boot.rest.services.LibraryServices;

@Service
public class LibraryServicesImpl implements LibraryServices {
	private LibraryRepository libraryRepo;
	
	@Autowired
	public LibraryServicesImpl(LibraryRepository libraryRepo) {
		super();
		this.libraryRepo = libraryRepo;
	}

	@Override
	public Book findBookById(Integer bid) {
		List<Book> books = libraryRepo.getBooks();
		Book bk = books.stream()
					   .filter(book -> book.getBookId().equals(bid))
					   .findFirst()
					   .orElse(null);
		return bk;
	}

	@Override
	public List<Book> findAll() {		
		return libraryRepo.getBooks();
	}

	@Override
	public boolean saveBook(Book book) {
		List<Book> books = libraryRepo.getBooks();
		Book existingBook = books.stream().filter(bk -> bk.getBookId().equals(book.getBookId())).findAny().orElse(null);
		System.out.println(existingBook);
		if(existingBook == null) {
			books.add(book);
			System.out.println(books);
			return true;
		}
		return false;
	}

}
