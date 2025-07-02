package com.cognizant.boot.beans;

import java.util.Random;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class DieselEngine implements Engine {

	@Override
	public boolean startEngine() {
		System.out.println("diesel engine starting");
		boolean status = new Random().nextBoolean();
		return status;
	}

}
