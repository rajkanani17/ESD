package com.rajkanani.esd_yummyapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class EsdYummyAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsdYummyAppApplication.class, args);
	}

}
