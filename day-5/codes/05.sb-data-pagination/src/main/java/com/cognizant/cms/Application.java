package com.cognizant.cms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.cognizant.cms.entities.Contact;
import com.cognizant.cms.repositories.ContactRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{
	@Autowired
	private ContactRepository contactRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		Page<Contact> page = contactRepo.findAll(Pageable.ofSize(5));
		List<Contact> contacts = page.getContent();
		contacts.forEach(System.out::println);
		*/
		
		/*
		//int pageNo = 0;
		int pageNo = 2;
		int pageSize = 5;
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		Page<Contact> page = contactRepo.findAll(pageRequest);
		List<Contact> contacts = page.getContent();
		contacts.forEach(System.out::println);
		*/
		
		int pageSize = 5;
		long noOfPages = contactRepo.count()/pageSize;
		if(contactRepo.count() % pageSize != 0) {
			noOfPages++;
		}
		
		for(int pageNo=0; pageNo<noOfPages; pageNo++) {
			PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
			Page<Contact> page = contactRepo.findAll(pageRequest);
			List<Contact> contacts = page.getContent();
			
			System.out.printf("==================== Page %d / %d ====================\n", (pageNo+1), noOfPages);
			contacts.forEach(System.out::println);
			
			System.out.println();
		}
	}

}
