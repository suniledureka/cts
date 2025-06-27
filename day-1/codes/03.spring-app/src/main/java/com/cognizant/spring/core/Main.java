package com.cognizant.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.spring.core.beans.User;

public class Main {

	public static void main(String[] args) {
		//initialize spring container (IoC)
		ApplicationContext context = new ClassPathXmlApplicationContext("user-beans.xml");
		System.out.println("=".repeat(60));
		System.out.println("spring container initialzed");	
		
		//((ConfigurableApplicationContext)context).close();
		((ConfigurableApplicationContext)context).registerShutdownHook();
	}
}