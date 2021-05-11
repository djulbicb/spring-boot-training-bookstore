package com.training.bookstore.controller;


import com.google.gson.Gson;
import com.training.bookstore.io.StorageFilesReader;
import com.training.bookstore.io.StorageFilesWriter;
import com.training.bookstore.model.resources.ShopResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/files/")
public class FilesController {

    @Autowired
    StorageFilesReader filesReader;
    @Autowired
    StorageFilesWriter filesWriter;
    @Autowired
    Gson gson;


    @RequestMapping("/write")
    public String write(@RequestParam(value = "filePath", required = false) String filePath, @RequestBody(required = false) String content) throws IOException {
        filesWriter.write(filePath, content);
        return "FilesController Wrote";
    }

    @RequestMapping("/read")
    public String read(@RequestParam("filePath") String filePath) throws IOException {
        return filesReader.read(filePath);
    }

    @RequestMapping("resource/write")
    public String writeResource (@RequestBody(required = false)ShopResource resource) throws IOException {
        filesWriter.write(resource, "This is just test of content");
        return "FilesController Wrote";
    }
}
