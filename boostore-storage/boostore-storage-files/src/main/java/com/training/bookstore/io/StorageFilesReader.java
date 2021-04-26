package com.training.bookstore.io;

import org.springframework.stereotype.Component;

@Component
public class StorageFilesReader {
    public String read (String filePath) {
        return "StorageFilesRead READ";
    }
}
