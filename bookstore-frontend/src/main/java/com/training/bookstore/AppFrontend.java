package com.training.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
public class AppFrontend {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(AppFrontend.class);
		ConfigurableApplicationContext run = app.run(args);

	}

}
