package com.capgemini.java.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {

	public static void main(String[] args) {
		Map<String, Float> bank = new LinkedHashMap<String, Float>();
		
		System.out.println(bank.put("Sunil", 25000f)); //null
		System.out.println(bank.put("Sunil", 11500.5f));//25000.0
		System.out.println(bank.put("Sahithi", 99999f)); //null
		
		bank.put("Charles", 25000f);
		bank.put("Rahul", 38750.5f);
		bank.put("Sagar", 85000f);
		
		System.out.println(bank);
		System.out.println();

		bank.put(null, null);
		System.out.println(bank);
	}

}
