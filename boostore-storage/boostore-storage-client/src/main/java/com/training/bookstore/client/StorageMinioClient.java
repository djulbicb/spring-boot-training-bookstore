package com.training.bookstore.client;

import com.training.bookstore.api.ApiEndpointConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StorageMinioClient {
    @Autowired
    ApiEndpointConsumer configuration;

    public String write (String bucketName, String identifier, String content) {
        RestTemplate template = new RestTemplate();
        MinioModel t = new MinioModel();
        t.setBucketName(bucketName);
        t.setIdentifier(identifier);
        t.setContent(content);


        return template.postForObject(configuration.getMinio().getLocation() + "/api/minio/write", t, String.class);
    }


    public String read (String bucketName, String identifier) {
        RestTemplate template = new RestTemplate();
        MinioModel t = new MinioModel();
        t.setBucketName(bucketName);
        t.setIdentifier(identifier);
        return template.getForObject(configuration.getMinio().getLocation() + "/api/minio/read", String.class);
    }
}
