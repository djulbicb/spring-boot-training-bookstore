package com.training.bookstore.io;

import com.training.bookstore.model.resources.ShopResource;
import com.training.bookstore.service.FilesPathResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class StorageFilesWriter {

    @Autowired
    FilesPathResolver pathResolver;

    public String write (ShopResource resource, String content) throws IOException {
        String filePath = pathResolver.resolve(resource);
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(content);
        }
        return "File saved";
    }

    public String write (String filePath, String content) throws IOException {
        filePath = pathResolver.resolve(filePath);
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(content);
        }
        return "File saved";
    }
}
