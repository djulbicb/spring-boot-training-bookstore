package com.training.bookstore.controller;

import com.training.bookstore.Endpoint;
import com.training.bookstore.EndpointConfiguration;
import io.minio.*;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

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
