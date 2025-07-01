package com.cognizant.boot.beans.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.cognizant.boot.utils.SecurityUtility;

@Configuration
public class AppConfiguration {

	public AppConfiguration() {
		System.out.println("AppConfiguration :: Constructor");
	}
	
	//@Bean
	//@Bean(name="security")
	//@Bean(value = {"security", "encoder"})
	@Bean(value = {"security", "encoder"}, initMethod = "myInit", destroyMethod = "destroy")
	//@Scope("singleton")
	@Scope("prototype")
	public SecurityUtility getSecUtil() {
		return new SecurityUtility();
	}
}
