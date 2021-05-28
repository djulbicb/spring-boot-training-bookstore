package com.training.bookstore.client;

import com.djulb.io.FileRead;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.training.bookstore.api.ApiEndpointConsumer;
import com.training.bookstore.model.resources.Resource;
import com.training.bookstore.model.resources.ShopResource;
import com.training.bookstore.model.site.SiteInfo;
import com.training.bookstore.sites.SiteConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.lang.reflect.Type;

@Component
public class StorageFilesClient {

    @Autowired
    ApiEndpointConsumer configuration;

    @Autowired
    RestTemplate rest;

    @Autowired
    Gson gson;

    public String write (String filePath, String content) {
        String url = configuration.getFiles().getLocation() + "write";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("filePath", filePath);

        return rest.postForObject(builder.toUriString(), content, String.class);
    }

    public String write (ShopResource resource) {
        String url = configuration.getFiles().getLocation() + "resource/write";
        rest.postForObject(url, resource, String.class);

        return "Reading shop resource";
    }

    public String read (String filePath) {
        String url = configuration.getFiles().getLocation() + "read";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("filePath", filePath);

        return rest.getForObject(builder.toUriString(), String.class);
    }

    public Resource[] readShopResource() {
        String url = UriComponentsBuilder.fromHttpUrl(configuration.getFiles().getLocation())
                .pathSegment("resources")
                .build().toUriString();
        return rest.getForObject(url, Resource[].class);
    }

    public SiteConfig[] getSiteConfigs() {
        String url = UriComponentsBuilder
                .fromHttpUrl(configuration.getFiles().getLocation())
                .pathSegment("sites")
                .build().toUriString();
        return rest.getForObject(url, SiteConfig[].class);
    }

    public <T> T getResourceByNameAndShop(String resourceName, String shopCode, Class<T> klass) {
        String url = UriComponentsBuilder.fromHttpUrl(configuration.getFiles().getLocation())
                .pathSegment("resource")
                .queryParam("resourceName", resourceName)
                .queryParam("shopCode", shopCode)
                .build().toUriString();

        TypeToken<T> token = TypeToken.get(klass);
        String configContent = rest.getForObject(url, String.class);
        return gson.fromJson(configContent, token.getType());
    }

}
