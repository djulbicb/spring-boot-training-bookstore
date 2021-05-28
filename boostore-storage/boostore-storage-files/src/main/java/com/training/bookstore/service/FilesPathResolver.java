package com.training.bookstore.service;

import com.training.bookstore.model.resources.Resource;
import com.training.bookstore.model.resources.ShopResource;
import com.training.bookstore.model.site.SiteInfo;
import com.training.bookstore.sites.SiteConfig;
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
        String subFolder = "";
        if (!resource.getType().equals(Resource.Type.GLOBAL)) {
            throw new IllegalArgumentException("Not expecting this type of resource");
        }
        return Paths.get(rootPath, resource.getType().name().toLowerCase(), resource.getCategory(), resource.getFileName()).toString();
    }

    public String resolve(Resource resource, SiteConfig shop) throws IOException {
        String subFolder = "";
        switch (resource.getType()) {
            case GLOBAL:
                throw new IllegalArgumentException("Not expecting this type of resource");
            case SHOPS_CASCADE_COUNTRY:
                subFolder = "cascade_country";
                break;
            case SHOPS_CASCADE_THEME:
                subFolder = "cascade_theme";
                break;
            case SHOPS_SITE:
                subFolder = "sites";
                break;
        }
        String path = Paths.get(rootPath, "shops", subFolder, shop.getCode(), resource.getCategory(), resource.getFileName()).toString();
        File file = new File(path);

        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
        return path;
    }
}