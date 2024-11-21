package com.rajkanani.esd_mini_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class EsdMiniProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsdMiniProjectApplication.class, args);
	}

}
