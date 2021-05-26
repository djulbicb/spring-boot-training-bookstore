package com.training.bookstore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppStorageConfiguration {

    @Bean
    public Gson beanGson() {
        return new GsonBuilder().setPrettyPrinting().create();
    }

    @Bean
    public RestTemplate beanRestTemplate() {
        return new RestTemplate();
    }

}
