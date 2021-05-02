package com.training.bookstore.controller;

import com.training.bookstore.api.ApiEndpointConsumer;
import com.training.bookstore.EndpointConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FrontendEndConfiguration implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

    @Autowired
    ApiEndpointConsumer apiEndpointConsumer;

    public void customize(ConfigurableServletWebServerFactory factory){
        factory.setPort(apiEndpointConsumer.getFrontend().getPort());
    }

}