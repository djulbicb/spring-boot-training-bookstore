package com.training.bookstore.controller;

import com.training.bookstore.EndpointConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/files/")
public class FilesController {

    @Autowired
    EndpointConfiguration configuration;

    @RequestMapping("/write")
    public String write() {
       return "FilesController Wrote";
    }


    @RequestMapping("/read")
    public String read() {
        return "FilesController read";
    }

}
