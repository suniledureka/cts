package com.cognizant.boot.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
	@Autowired
	private Engine engine;

	public void startJourney() {
		System.out.println("starting journey");
		boolean engineStatus = engine.startEngine();
		if(engineStatus)
			System.out.println("Journey Started... Happy Journey");
		else
			System.out.println("Engine not starting ... Journey Cancelled");
	}
}
