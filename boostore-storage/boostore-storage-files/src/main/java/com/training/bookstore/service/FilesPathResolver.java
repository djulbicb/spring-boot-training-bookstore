package com.training.bookstore.service;

import com.training.bookstore.model.ShopConfig;
import com.training.bookstore.resources.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FilesPathResolver {

    private final String rootPath;

    @Autowired
    public FilesPathResolver(
            @Value("${storage.root}") String rootPath) {
        this.rootPath = rootPath;
        System.out.println(rootPath);
    }

    public String getResourceGlobalPath(Resource resource) {
        Path path = Paths.get(rootPath, resource.getType().toString().toLowerCase(), resource.getName(), resource.getVersion(),  resource.getPath());
        File file = new File(path.toUri());
        if (!file.getParentFile().exists()) {
            file.mkdirs();
        }
        return path.toFile().getAbsolutePath();
    }

    public String getResourcePath(ShopConfig config, Resource resource) {
        Path path = Paths.get(rootPath, resource.getType().toString().toLowerCase(), config.getCode(), resource.getName(), resource.getVersion(), resource.getPath());
        File file = new File(path.toUri());
        if (!file.getParentFile().exists()) {
            file.mkdirs();
        }
        return path.toFile().getAbsolutePath();
    }
}