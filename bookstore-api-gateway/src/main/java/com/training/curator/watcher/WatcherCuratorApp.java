package com.training.curator.watcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class WatcherCuratorApp {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(WatcherCuratorApp.class);
		ConfigurableApplicationContext run = app.run(args);
	}

}
