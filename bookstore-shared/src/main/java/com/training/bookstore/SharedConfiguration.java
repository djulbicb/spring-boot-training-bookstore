package com.training.bookstore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import data.DataLibrary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SharedConfiguration {

    @Bean
    public DataLibrary dataLibrary () {
        return DataLibrary.getEnglishData();
    }
    @Bean
    public RestTemplate restTemplate () {
        return new RestTemplate();
    }
    @Bean
    public Gson gson () {
        return new GsonBuilder().setPrettyPrinting().create();
    }
}
