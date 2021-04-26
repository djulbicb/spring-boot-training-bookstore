package com.training.bookstore.client;

import com.training.bookstore.EndpointConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StorageFilesClient {

    @Autowired
    EndpointConfiguration configuration;

    public String write (String filePath, String content) {
        RestTemplate template = new RestTemplate();
        return template.postForObject(configuration.getFiles().getLocation() + "/api/files/write", content, String.class);
    }

    public String read (String filePath) {
        RestTemplate template = new RestTemplate();
        return template.getForObject(configuration.getFiles().getLocation() + "/api/files/read", String.class);
    }
}
