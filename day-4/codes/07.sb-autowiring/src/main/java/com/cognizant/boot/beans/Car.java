package com.cognizant.boot.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {
	
	@Autowired
	@Qualifier(value = "petrolEngine")
	private Engine engine;
	
	public Car() {
		System.out.println("Car :: Constructor");
	}

	public void startJourney() {
		System.out.println("starting journey...");
		boolean engineStatus = engine.startEngine();
		
		if(engineStatus)
			System.out.println("###--- HAPPY JOURNEY ---####");
		else
			System.err.println("@@@--- JOURNEY CANCELLED ---@@@");
	}	
}
