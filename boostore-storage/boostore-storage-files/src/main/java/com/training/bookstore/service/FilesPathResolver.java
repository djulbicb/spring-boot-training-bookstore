package com.training.bookstore.service;

import com.training.bookstore.model.resources.ShopResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class FilesPathResolver {

    private final String rootPath;

    @Autowired
    public FilesPathResolver( @Value("${storage.root}") String rootPath) {
        this.rootPath = rootPath;
    }

    public String resolve (ShopResource resource) {
        String filePath = String.format("%s/%s/%s/%s", rootPath, resource.getResource().getType(), resource.getShop().getShopCode(), resource.getResource().getCategory(), resource.getResource().getName());
        File file = new File(filePath);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        return filePath;
    }

    public String resolve (String filePath) {
        filePath = rootPath + filePath;
        File file = new File(filePath);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        return filePath;
    }
}