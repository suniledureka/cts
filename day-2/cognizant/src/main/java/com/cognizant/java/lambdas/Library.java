package com.cognizant.java.lambdas;

import java.util.List;
import java.util.function.Consumer;

public class Library {

	public static void main(String[] args) throws InterruptedException {
		BookServices libraryService = new BookServices();
		
		List<Book> books = libraryService.getAllBooksInAscendingOrderOfId();
		
		/*
		Consumer<Book> bkConsumer = new Consumer<Book>() {
			@Override
			public void accept(Book t) {
				System.out.println(t);				
			}			
		};
		*/
		/*
		Consumer<Book> bkConsumer = (Book t) -> {
				System.out.println(t);				
			};			
		*/
		
		/*
		Consumer<Book> bkConsumer = t -> System.out.println(t);	
		books.forEach(bkConsumer);
		*/
		
		books.forEach(book -> System.out.println(book));
	}

}
