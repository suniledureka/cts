package com.cognizant;

import java.lang.reflect.Field;

import com.cognizant.models.Product;

public class Test {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Product prod = new Product();
		System.out.println(prod);
		
		Field prodNameField = prod.getClass().getDeclaredField("productName");
		prodNameField.setAccessible(true);
		
		prodNameField.set(prod, "Mobile");
		System.out.println(prod);
	}

}
