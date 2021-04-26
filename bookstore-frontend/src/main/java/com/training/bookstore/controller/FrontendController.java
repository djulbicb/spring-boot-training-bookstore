package com.training.bookstore.controller;

import com.training.bookstore.client.StorageFilesClient;
import com.training.bookstore.client.StorageMinioClient;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping("/")
public class
FrontendController {

    @Autowired
    StorageFilesClient filesClient;

    @Autowired
    StorageMinioClient minioClient;

    @GetMapping("")
    public String getIndex() throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, ErrorResponseException {
        minioClient.write("bojan", "sss", "This is content");
        minioClient.read("bojan", "sss");

        String write = filesClient.write("file", "www this is content");
        System.out.println(write);



        String file = filesClient.read("file");
        return "index";
    }

}
