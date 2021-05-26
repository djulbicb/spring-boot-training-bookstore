package com.training.bookstore.controller;


import com.training.bookstore.io.StorageFilesReader;
import com.training.bookstore.io.StorageFilesWriter;
import com.training.bookstore.model.resources.Resource;
import com.training.bookstore.model.resources.ShopResource;
import com.training.bookstore.service.ResourceService;
import com.training.bookstore.sites.SiteConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/files/")
public class FilesController {

    @Autowired
    StorageFilesReader filesReader;
    @Autowired
    StorageFilesWriter filesWriter;
    @Autowired
    ResourceService resourceService;

    @GetMapping("resources")
    public Resource[] readResourceDefinitions() throws IOException {
        return resourceService.getAllResources();
    }

    @GetMapping("sites")
    public SiteConfig[] readSitesDefinitions() throws IOException {
        return resourceService.getSitesResource();
    }


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
