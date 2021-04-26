package com.training.bookstore.io;

import org.springframework.stereotype.Component;

@Component
public class StorageFilesWriter {
    public String write (String filePath, String content) {
        return "StorageFilesWriter WRITE";
    }
}
