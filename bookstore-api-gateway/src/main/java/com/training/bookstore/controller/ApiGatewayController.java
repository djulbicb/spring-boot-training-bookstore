package com.training.bookstore.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/api/**")
@RestController
public class ApiGatewayController {

    @GetMapping("/minio")
    public ResponseEntity<String> getMinio() {
        System.out.println("Hello from ApiGatewayController minio");
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity("http://localhost:8500/api/minio", String.class);
    }

    @GetMapping("/backend")
    public String getBackend() {
        System.out.println("Hello from ApiGatewayController backend");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForEntity("http://localhost:8500", String.class);
        return "index";
    }

    @GetMapping("/files")
    public String getFiles() {
        System.out.println("Hello from ApiGatewayController files");
        return "index";
    }

}
