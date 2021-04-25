package com.training.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class TestController {

    @Autowired
    Environment environment;

    @GetMapping("")
    public String test() {
        System.out.println(environment);
        System.out.println(environment.getProperty("shared"));
        System.out.println(environment.getProperty("test"));
        return "test";
    }
}
