package com.cognizant.boot.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "PRODUCT_MASTER")
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class Product {
	@Id
	@GeneratedValue
	private Integer productId;
	private String productName;
	private Float productPrice;

	public Product(String productName, Float productPrice) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
	}

}
