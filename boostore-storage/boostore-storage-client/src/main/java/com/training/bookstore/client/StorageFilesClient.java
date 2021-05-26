package com.training.bookstore.client;

import com.sun.javafx.fxml.builder.URLBuilder;
import com.sun.xml.internal.bind.v2.schemagen.episode.Klass;
import com.training.bookstore.api.ApiEndpointConsumer;
import com.training.bookstore.model.resources.Resource;
import com.training.bookstore.model.resources.ShopResource;
import com.training.bookstore.model.site.SiteInfo;
import com.training.bookstore.sites.SiteConfig;
import com.training.bookstore.sites.SiteConfigConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.file.Paths;

@Component
public class StorageFilesClient {

    @Autowired
    ApiEndpointConsumer configuration;

    @Autowired
    RestTemplate rest;

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

    public void getResourceForShop(Object homePage, SiteInfo siteInfo, Class klass) {

    }
}
