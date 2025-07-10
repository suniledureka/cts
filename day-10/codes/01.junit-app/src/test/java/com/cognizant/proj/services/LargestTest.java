package com.cognizant.proj.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LargestTest {
	static Largest larObj;
	
	@BeforeAll
	public static void testInitialization() {
		System.out.println("before all tests");
		larObj = new Largest();
	}
	
	@AfterAll
	public static void testsCompleted() {
		System.out.println("after all tests");
		larObj = null;
	}
	
	@Test
	void testFindLargest() {
		//Largest larObj = new Largest();
		
		int [] data = {7, 45, 63, 20, 12, 9};
		int expected = 63;
		int actual = larObj.findLargest(data);

		assertEquals(expected, actual);
	}

	@Test
	void testFindLargest1() {
		//Largest larObj = new Largest();
		
		int [] data = {7, -45, -63, 20, 12, 9};
		int expected = 20;
		int actual = larObj.findLargest(data);

		assertEquals(expected, actual);
	}
	
	@Test
	void testFindLargest2() {
		//Largest larObj = new Largest();
		
		int [] data = {-7, -45, -63, -20, -12, -9};
		int expected = -7;
		int actual = larObj.findLargest(data);

		assertEquals(expected, actual);
	}	
	
	@Test
	void testFindLargest3() {
		//Largest larObj = new Largest();
		
		int [] data = {};
		
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> larObj.findLargest(data));
	}	
}
