package com.cognizant.cms;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		//----- to get the number of contacts -----
		long noOfContacts = contactRepo.count();
		System.out.println("no of contacts = " + noOfContacts);
		System.out.println();
		
		//----- to check whether a contact is existing with a contactId or not
		boolean isExists = contactRepo.existsById(109);
		System.out.println("is a contact with contact ID: 109 exists = " + isExists);
		System.out.println();
		
		//----- to get a Contact based on contactId( ID property value)
		int cid = 101;
		Optional<Contact> optContact = contactRepo.findById(cid);
		if(optContact.isPresent()) {
			Contact ct = optContact.get();
			System.out.println(ct);
		}else {
			System.out.println("no matching contact found for contactId: " + cid);
		}
		System.out.println();
		
		//----- to get Contacts based on multiple contactIds -----
		List<Integer> contactIds = Arrays.asList(101, 202, 605, 103, 105, 107);		
		Iterable<Contact> contacts = contactRepo.findAllById(contactIds);
		printContacts(contacts);
		System.out.println();
		
		//-- ----- to get all contacts -----
		contacts = contactRepo.findAll();
		printContacts(contacts);		
	}

	private void printContacts(Iterable<Contact> contacts) {
		contacts.forEach(ct -> {
			System.out.println(ct);
			try {
				Thread.sleep(1500);
			}catch(Exception ex) {}
		});		
	}

}
