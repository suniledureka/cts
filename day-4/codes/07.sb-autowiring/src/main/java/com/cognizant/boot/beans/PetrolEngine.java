package com.cognizant.boot.beans;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class PetrolEngine implements Engine {

	@Override
	public boolean startEngine() {
		System.out.println("petrol engine starting");
		boolean status = new Random().nextBoolean();
		return status;
	}

}
