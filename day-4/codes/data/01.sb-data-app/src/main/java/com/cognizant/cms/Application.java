package com.cognizant.cms;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cognizant.cms.entities.Contact;
import com.cognizant.cms.repositories.ContactRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		System.out.println();
		
		ContactRepository contactRepo = context.getBean(ContactRepository.class);
		
		/*
		 * ContactRepository is an interface - then how come instance? 
		 * - uses Proxy Design Pattern- implementation class is being created internally
		 */
		System.out.println("implementation class of contactRepo = " + contactRepo.getClass().getName());
		System.out.println();
		
		/*
		//--save a contact
		Contact contact = new Contact();
		contact.setContactId(102);
		contact.setContactName("Praveen Kumar");
		contact.setContactNumber("9848586878");
		
		//contactRepo.save(contact);
		Contact savedContact = contactRepo.save(contact);
		System.out.println("contact saved - " + savedContact);
		*/
		
		//-- save multiple contacts
		Contact ct1 = new Contact(103, "Ajay", "8574968596");
		Contact ct2 = new Contact(104, "Bharath", "9574968596");
		Contact ct3 = new Contact(105, "Sagar", "6574968596");
		Contact ct4 = new Contact(106, "Srinivas", "7574968596");
		Contact ct5 = new Contact(107, "Valerie", "9874968596");
		
		List<Contact> contacts = Arrays.asList(ct1, ct2, ct3, ct4, ct5);
		
		contactRepo.saveAll(contacts);
		
		context.close();		
	}

}
