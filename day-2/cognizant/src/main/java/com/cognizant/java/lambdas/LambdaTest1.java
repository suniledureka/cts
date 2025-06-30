package com.cognizant.java.lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaTest1 {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Sanjay", "Praveen","Aravind", "Bharath", "Wilson", "Charles");
		System.out.println(names);
		
		Comparator<String> stringAscedingComp = (o1, o2) -> o1.compareTo(o2);
		names.sort(stringAscedingComp);
		System.out.println(names);
	}

}
