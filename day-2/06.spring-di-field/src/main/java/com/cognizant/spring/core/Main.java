package com.cognizant.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.spring.core.beans.Customer;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("customer-car-beans.xml");
		
		Customer sanjay = (Customer)context.getBean("sanjay");
		
		System.out.println(sanjay.getCustomerName() +", owns a " + sanjay.getCar().getModel() + " car, costs Rs."+sanjay.getCar().getCost());

	}

}
