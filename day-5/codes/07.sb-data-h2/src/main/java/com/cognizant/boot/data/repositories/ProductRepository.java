package com.cognizant.boot.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.boot.data.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
