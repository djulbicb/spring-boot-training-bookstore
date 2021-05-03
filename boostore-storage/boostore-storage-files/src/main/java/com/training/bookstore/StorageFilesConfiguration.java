package com.training.bookstore;

import com.training.bookstore.api.ApiEndpointConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
public class StorageFilesConfiguration implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

    @Autowired
    ApiEndpointConsumer configuration;

    public void customize(ConfigurableServletWebServerFactory factory){
        factory.setPort(configuration.getFiles().getPort());
    }
}