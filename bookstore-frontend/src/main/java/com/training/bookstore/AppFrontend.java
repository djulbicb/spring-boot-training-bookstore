package com.training.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AppFrontend {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(AppFrontend.class);
		ConfigurableApplicationContext run = app.run(args);
	}

}
