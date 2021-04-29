package com.training.bookstore.controller;

import com.training.bookstore.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BackendController {

    @GetMapping("")
    public String getIndex() {
        return "index";
    }

    @PostMapping("")
    public String postIndex(@RequestBody Book book) {
        System.out.println(book);
        return "index";
    }

}
