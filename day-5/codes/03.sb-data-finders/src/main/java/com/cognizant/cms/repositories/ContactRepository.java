package com.cognizant.cms.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.cms.entities.Contact;

public interface ContactRepository extends CrudRepository<Contact, Integer> {

	Optional<Contact> findByContactName(String string);
	
	Contact findByContactNumber(String cnumber);

	Optional<Contact> findByContactNameAndContactNumber(String string, String string2);

	List<Contact> findByContactNameOrContactNumber(String string, String string2);

	//@Query("select contactName from com.cognizant.cms.entities.Contact") //HQL
	@Query(value = "select contact_name from contact_master", nativeQuery = true) //SQL
	List<String> findAllContactName();

	//@Query("from com.cognizant.cms.entities.Contact where contactName=?1") //positional parameters
	//@Query("from com.cognizant.cms.entities.Contact where contactName=:cname") //named parameters
	//@Query("select ct from com.cognizant.cms.entities.Contact ct where contactName = :cname")
	@Query(value = "select * from contact_master where contact_name=:cname", nativeQuery = true)
	Optional<Contact> findByCtName(String cname);
	
	@Query("select ct from com.cognizant.cms.entities.Contact ct where contactName LIKE :cnameLike%")
	List<Contact> findContactsWhereNamesWith(String cnameLike);


}
