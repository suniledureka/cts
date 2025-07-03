package com.cognizant.cms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.cms.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
