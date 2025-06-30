package com.cognizant.java.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PredicateTest1 {

	public static void main(String[] args) {
		List<Integer> numsList = Arrays.asList(11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
		System.out.println("original data = " + numsList);
		
		Stream<Integer> numsStream1 = numsList.stream();
		Stream<Integer> numsStream2 =numsStream1.filter(t -> t%2==0);
			
		List<Integer> evenNumsList = numsStream2.collect(Collectors.toList());
		System.out.println("even nums = " + evenNumsList);
		
		List<Integer> oddNumsList = numsList.stream().filter(t -> t%2!=0).collect(Collectors.toList());
		System.out.println("odd nums = " + oddNumsList);
	}

}
