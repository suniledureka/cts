package com.cognizant.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cognizant.boot.beans.Car;
import com.cognizant.boot.utils.SecurityUtility;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		System.out.println();
		System.out.println("no of beans configured = " + context.getBeanDefinitionCount());
		
		System.out.println();
		
		//Car car = context.getBean(Car.class);
		//Car car = (Car) context.getBean("car");
		//Car car = context.getBean("car", Car.class);
		Car car = (Car) context.getBean("mycar");
		car.startJourney();
		System.out.println();
		
		//SecurityUtility secUtilRef = context.getBean(SecurityUtility.class);
		//SecurityUtility secUtilRef = (SecurityUtility) context.getBean("getSecUtil");
		//SecurityUtility secUtilRef = (SecurityUtility) context.getBean("security");
		SecurityUtility secUtilRef = (SecurityUtility) context.getBean("encoder");
		String password = "password123#";
		String encodedPass = secUtilRef.encodeData(password);
		System.out.println("encoded password = " + encodedPass);
		
		SecurityUtility secUtilRef1 = (SecurityUtility) context.getBean("encoder");
	}

}
