package com.training.bookstore.client;

import com.training.bookstore.EndpointConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StorageMinioClient {
    @Autowired
    EndpointConfiguration configuration;

    public String write (String bucketName, String identifier, String writer) {
        RestTemplate template = new RestTemplate();
        MinioModel t = new MinioModel();
        t.setBucketName("bojan");
        t.setIdentifier("idtt");
        t.setIdentifier("This is content");


        return template.postForObject(configuration.getMinio().getLocation() + "/api/minio/write", t, String.class);
    }


    public String read (String bucketName, String identifier) {
        RestTemplate template = new RestTemplate();
        MinioModel t = new MinioModel();
        t.setBucketName("bojan");
        t.setIdentifier("idtt");
        t.setIdentifier("This is content");
        return template.postForObject(configuration.getMinio().getLocation() + "/api/minio/write", t, String.class);
    }
}
