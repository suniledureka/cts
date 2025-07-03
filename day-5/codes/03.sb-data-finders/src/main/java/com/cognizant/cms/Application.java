package com.cognizant.cms;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.cms.entities.Contact;
import com.cognizant.cms.repositories.ContactRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
	static String project = "online bookstore";
	static int version = 12;

	Contact ct = null;

	private ContactRepository contactRepo;

	@Autowired
	public Application(ContactRepository contactRepo) {
		super();
		this.contactRepo = contactRepo;
	}

	public static void main(String[] args) {
		LOGGER.info("initializing spring container");
		SpringApplication.run(Application.class, args);
		LOGGER.error("spring container initialized - {} @ {}", project, version);
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("inside commandlinerunner run()");

		String cname = "Praveen";
		Optional<Contact> optContact = contactRepo.findByContactName(cname);
		if (optContact.isPresent()) {
			ct = optContact.get();
			LOGGER.info(ct.toString());
		} else {
			LOGGER.warn("no matching contact found for \"{}\"", cname);
		}
		System.out.println("=".repeat(100) + "\n");

		ct = contactRepo.findByContactNumber("9848586878");
		System.out.println(ct);
		System.out.println("=".repeat(100) + "\n");
		
		optContact = contactRepo.findByContactNameAndContactNumber("Valerie", "9874968596");
		if(optContact.isPresent()) {
			ct = optContact.get();
			System.out.println(ct);
		}else {
			System.err.println("no matching contact with specified name and number");
		}
		
		System.out.println("=".repeat(100) + "\n");

		List<Contact> listContacts = contactRepo.findByContactNameOrContactNumber("Praveen", "9874968596");
		listContacts.stream().forEach(System.out::println);		
		System.out.println("=".repeat(100) + "\n");
		
		List<String> contactNames = contactRepo.findAllContactName();
		System.out.println("====== CONTACT NAMES ======");
		contactNames.stream().forEach(name -> System.out.println(name));
		System.out.println("=".repeat(100) + "\n");
		
		optContact = contactRepo.findByCtName("Ajay");
		if(optContact.isPresent()) {
			ct = optContact.get();
			System.out.println(ct);
		}else {
			System.err.println("no matching contact with specified name");
		}
		System.out.println("=".repeat(100) + "\n");	
		
		listContacts = contactRepo.findContactsWhereNamesWith("S");
		listContacts.stream().forEach(System.out::println);		
	}

}
