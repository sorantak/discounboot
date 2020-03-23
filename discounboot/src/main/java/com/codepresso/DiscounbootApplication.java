package com.codepresso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiscounbootApplication {

	public static void main(String[] args) {
		SpringApplication application = 
				new SpringApplication(DiscounbootApplication.class);
		application.setWebApplicationType(WebApplicationType.NONE);
		application.run(args);
	}

}
