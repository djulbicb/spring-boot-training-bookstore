package com.training.bookstore.controller;

import com.training.bookstore.EndpointConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class FrontendController {

    @Autowired
    EndpointConfiguration configuration;

    @Autowired
    Environment environment;


    @GetMapping("")
    public String getIndex() {
        System.out.println(configuration);
        return "index";
    }

}
