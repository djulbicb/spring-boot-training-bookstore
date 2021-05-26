package com.training.bookstore.service;

import com.training.bookstore.model.resources.Resource;
import com.training.bookstore.model.resources.ShopResource;
import com.training.bookstore.model.site.SiteInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@Service
public class FilesPathResolver {

    private final String rootPath;

    @Autowired
    public FilesPathResolver( @Value("${storage.root}") String rootPath) {
        this.rootPath = rootPath;
    }

    public String resolve (ShopResource shopResource) throws IOException {
        SiteInfo meta = shopResource.getShop();
        Resource resource = shopResource.getResource();

        String filePath = Paths.get(rootPath, resource.getType().name().toLowerCase(), resource.getCategory(), resource.getStoragePath()).toString();

        File file = new File(filePath);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
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

    public String resolve(Resource resource) {
        return Paths.get(rootPath, resource.getType().name().toLowerCase(), resource.getCategory(), resource.getFileName()).toString();
    }
}