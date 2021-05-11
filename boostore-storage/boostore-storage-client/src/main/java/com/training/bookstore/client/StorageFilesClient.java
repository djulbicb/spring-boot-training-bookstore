package com.training.bookstore.client;

import com.training.bookstore.api.ApiEndpointConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class StorageFilesClient {

    @Autowired
    ApiEndpointConsumer configuration;

    public String write (String filePath, String content) {
        RestTemplate template = new RestTemplate();

        String url = configuration.getFiles().getLocation() + "write";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("filePath", filePath);

        return template.postForObject(builder.toUriString(), content, String.class);
    }

    public String read (String filePath) {
        RestTemplate template = new RestTemplate();

        String url = configuration.getFiles().getLocation() + "read";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("filePath", filePath);

        return template.getForObject(builder.toUriString(), String.class);
    }
}
