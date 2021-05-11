package com.training.bookstore.controller;


import com.training.bookstore.io.StorageFilesReader;
import com.training.bookstore.io.StorageFilesWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/files/")
public class FilesController {

    @Autowired
    StorageFilesReader filesReader;
    @Autowired
    StorageFilesWriter filesWriter;

    @RequestMapping("/write")
    public String write() {
        return "FilesController Wrote";
    }

    @RequestMapping("/read")
    public String read() {
        return filesReader.read("somePath.txt");
    }
}
