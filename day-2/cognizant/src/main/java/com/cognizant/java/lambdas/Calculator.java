package com.cognizant.java.lambdas;

public class Calculator {

	public static void main(String[] args) {
		// using anonymous class concept
		Nums numsRef1 = new Nums() {
			@Override
			public int add(int x, int y) {
				return x + y;
			}			
		};
		
		System.out.println("sum = " + numsRef1.add(5, 4));
		
		// using lambda expressions
		Nums numsRef2 = (int x, int y) -> {
				return x + y;
			};
		
		System.out.println("sum = " + numsRef2.add(5, 4));	
		
		// using lambda expressions
		Nums numsRef3 = (x, y) -> x + y;		
		System.out.println("sum = " + numsRef3.add(5, 4));			
	}

}
