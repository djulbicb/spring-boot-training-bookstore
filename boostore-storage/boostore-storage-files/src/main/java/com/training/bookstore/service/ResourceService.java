package com.training.bookstore.service;

import com.djulb.io.FileRead;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.training.bookstore.model.resources.Resource;
import com.training.bookstore.model.resources.ResourceNames;
import com.training.bookstore.model.resources.ShopResource;
import com.training.bookstore.sites.SiteConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ResourceService {

    @Autowired
    FilesPathResolver filesPathResolver;

    @Autowired
    Gson gson;

    public <T> T getGlobalResource (Resource resource, Class<T> klass) throws IOException {
        String resourcePath = filesPathResolver.resolve(resource);
        String configContent = FileRead.readString(resourcePath);

        TypeToken<T> type = TypeToken.get(klass);
        return gson.fromJson(configContent, type.getType());
    }

    public <T> T getShopResource (ShopResource shopResource, Class<T> klass) throws IOException {
        String resourcePath = filesPathResolver.resolve(shopResource);
        String configContent = FileRead.readString(resourcePath);

        TypeToken<T> type = TypeToken.get(klass);
        return gson.fromJson(configContent, type.getType());
    }

    public Resource getResourceByName (String resourceName) {
        try {
            Resource[] allResources = getAllResources();

            for (Resource resource : allResources) {
                if (resource.getName().equals(resourceName)) {
                    return resource;
                }
            }
            throw new IllegalArgumentException("Cant find resource " + resourceName);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Cant find resource " + resourceName);
        }
    }

    public Resource[] getAllResources() throws IOException {
        Resource configResources = getConfigResources();
        String resourcePath = filesPathResolver.resolve(configResources);
        String configContent = FileRead.readString(resourcePath);
        return gson.fromJson(configContent, Resource[].class);
    }

    public Resource getConfigResources () {
        Resource resource = new Resource();
        resource.setType(Resource.Type.GLOBAL);
        resource.setName(ResourceNames.CONFIG_RESOURCES);
        resource.setFileName(ResourceNames.CONFIG_RESOURCES + ".json");
        resource.setCategory("sites");
        resource.setCloudPath("/sites/config-resources.json");
        resource.setStoragePath("/sites/config-resources.json");
        return resource;
    }

    public SiteConfig[] getSitesResource() throws IOException {
        Resource resource = getResourceByName(ResourceNames.CONFIG_SITES);
        return getGlobalResource(resource, SiteConfig[].class);
    }
}
