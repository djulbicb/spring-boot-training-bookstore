package com.training.bookstore.io;

import com.training.bookstore.model.ShopConfig;
import com.training.bookstore.resources.Resource;
import org.springframework.stereotype.Component;

@Component
public class StorageFilesWriter {
    public String write (String filePath, String content) {
        return "StorageFilesWriter WRITE";
    }
}
