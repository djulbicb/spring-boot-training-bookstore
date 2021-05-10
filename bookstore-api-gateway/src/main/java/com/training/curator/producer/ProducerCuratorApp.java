package com.training.curator.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
public class ProducerCuratorApp {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ProducerCuratorApp.class);
		ConfigurableApplicationContext run = app.run(args);
	}

}
