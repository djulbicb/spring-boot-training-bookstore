package com.training.bookstore.config;

import com.training.bookstore.api.ApiEndpointConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StorageFilesConfiguration implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

    @Autowired
    ApiEndpointConsumer configuration;

    @Value("${storage.root}")
    private String rootPath;

    public void customize(ConfigurableServletWebServerFactory factory){
        System.out.println(rootPath);
        factory.setPort(configuration.getFiles().getPort());
    }
}