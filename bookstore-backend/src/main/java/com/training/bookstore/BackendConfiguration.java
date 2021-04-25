package com.training.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BackendConfiguration implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

    @Autowired
    SharedAutoConfiguration configuration;

    public void customize(ConfigurableServletWebServerFactory factory){
        factory.setPort(configuration.getFrontendServerPort());
    }
}