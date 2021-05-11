package com.training.bookstore.io;

import com.training.bookstore.service.FilesPathResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class StorageFilesReader {
    @Autowired
    FilesPathResolver pathResolver;

    public String read (String filePath) throws IOException {
        filePath = pathResolver.resolve(filePath);
        String text = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
        return text;
    }
}
