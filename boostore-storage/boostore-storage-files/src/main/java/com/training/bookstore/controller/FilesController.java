package com.training.bookstore.controller;


import com.training.bookstore.io.StorageFilesReader;
import com.training.bookstore.io.StorageFilesWriter;
import com.training.bookstore.model.ShopConfig;
import com.training.bookstore.resources.Resource;
import com.training.bookstore.resources.shop.StaticPageResource;
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

        ShopConfig config = new ShopConfig();
        Resource resource = new StaticPageResource();
        filesWriter.writeShopResource(config, resource);

        filesWriter.write("somePath.txt", "This is content");
        return "FilesController Wrote";
    }



    @RequestMapping("/read")
    public String read() {
        return filesReader.read("somePath.txt");
    }
}
