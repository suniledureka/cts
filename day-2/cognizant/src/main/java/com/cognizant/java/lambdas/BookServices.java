package com.cognizant.java.lambdas;

import java.util.List;

public class BookServices {
	public List<Book> getAllBooksInAscendingOrderOfId(){
		List<Book> books = new BooksDAO().getAllBooks();
		
		books.sort((book1, book2) -> book1.getBookId() - book2.getBookId());
		
		return books;
	}
}
