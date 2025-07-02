package com.cognizant.boot.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
	private Engine engine;

	public Car() {
		System.out.println("no args constructor");
	}
	
	@Autowired
	public Car(Engine engine) {
		this.engine = engine;
		System.out.println("Car :: Constructor");
	}

	public Engine getEngine() {
		return engine;
	}

	public void startJourney() {
		System.out.println("starting journey");
		boolean engineStatus = engine.startEngine();
		if (engineStatus)
			System.out.println("Journey Started... Happy Journey");
		else
			System.err.println("Engine not starting ... Journey Cancelled");
	}
}
