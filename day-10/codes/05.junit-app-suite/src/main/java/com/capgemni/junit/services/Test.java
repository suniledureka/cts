package com.capgemni.junit.services;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		Random random = new Random();
		
		//float f = random.nextFloat();
		//float f = random.nextFloat(10000f);
		//int f = random.nextInt();
		//int f = random.nextInt(25000);
		int f = random.nextInt(10000, 99999);
		System.out.println(f);

	}

}
