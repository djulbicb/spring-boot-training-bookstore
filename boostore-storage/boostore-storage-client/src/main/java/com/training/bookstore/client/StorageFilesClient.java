package com.training.bookstore.client;

import com.training.bookstore.api.ApiEndpointConsumer;
import com.training.bookstore.model.ShopConfig;
import com.training.bookstore.resources.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StorageFilesClient {

    @Autowired
    ApiEndpointConsumer configuration;

    public String write (String filePath, String content) {
        RestTemplate template = new RestTemplate();
        return template.postForObject(configuration.getFiles().getLocation() + "/api/files/write", content, String.class);
    }

    public String read (String filePath) {
        RestTemplate template = new RestTemplate();
        return template.getForObject(configuration.getFiles().getLocation() + "/api/files/read", String.class);
    }

    public void write (ShopConfig config, Resource resource, String content) {

    }

    public void read (ShopConfig config, Resource resource) {

    }
}
