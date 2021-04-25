package com.training.bookstore;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.ResourceUtils;

@Configuration
@PropertySource(ResourceUtils.CLASSPATH_URL_PREFIX + "application-shared.properties")
public class SharedAutoConfiguration {
    @Value("${frontend.server.port}")
    private int frontendServerPort;

    public int getFrontendServerPort() {
        return frontendServerPort;
    }
}
