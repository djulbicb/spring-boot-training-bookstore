package com.training.bookstore;

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
}
