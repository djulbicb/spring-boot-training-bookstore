package com.training.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FilesPathResolver {

    private final String rootPath;

    @Autowired
    public FilesPathResolver( @Value("${storage.root}") String rootPath) {
        this.rootPath = rootPath;
    }

}