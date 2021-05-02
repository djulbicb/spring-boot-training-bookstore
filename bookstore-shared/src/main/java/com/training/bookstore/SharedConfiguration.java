package com.training.bookstore;

import data.DataLibrary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SharedConfiguration {

    @Bean
    public DataLibrary dataLibrary () {
        return DataLibrary.getEnglishData();
    }
}
