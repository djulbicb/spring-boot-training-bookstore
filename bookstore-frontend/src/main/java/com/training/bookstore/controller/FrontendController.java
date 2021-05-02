package com.training.bookstore.controller;

import com.training.bookstore.BackendClient;
import com.training.bookstore.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class
FrontendController {

    @Autowired
    BackendClient backendClient;

//    @Autowired
//    StorageFilesClient filesClient;
//
//    @Autowired
//    StorageMinioClient minioClient;


    @GetMapping("")
    public String getIndex(Model model) {
        List<Book> all = backendClient.findAll();

//        minioClient.write("bojan", "sss", "This is content");
//        minioClient.read("bojan", "sss");

//        String write = filesClient.write("file", "www this is content");
//        System.out.println(write);
//
//
//
//        String file = filesClient.read("file");


        model.addAttribute("bojan", "Model bojan");
        model.addAttribute("books", all);
        return "index";
    }

}
