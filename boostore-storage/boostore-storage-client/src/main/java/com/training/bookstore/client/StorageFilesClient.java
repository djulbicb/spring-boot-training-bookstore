package com.training.bookstore.client;

import com.training.bookstore.api.ApiEndpointConsumer;
import com.training.bookstore.model.resources.GlobalResource;
import com.training.bookstore.model.resources.ShopResource;
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

    public String write (ShopResource resource) {
        RestTemplate template = new RestTemplate();

        String url = configuration.getFiles().getLocation() + "resource/write";
        template.postForObject(url, resource, String.class);

        return "Reading shop resource";
    }

    public String write (GlobalResource resource) {
        return "Writing global resource";
    }

    public String read (String filePath) {
        RestTemplate template = new RestTemplate();

        String url = configuration.getFiles().getLocation() + "read";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("filePath", filePath);

        return template.getForObject(builder.toUriString(), String.class);
    }


}
