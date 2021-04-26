package com.training.bookstore.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/api/minio")
@RestController
public class MinioController {

    @GetMapping("")
    public ResponseEntity<String> getBackend() {
        RestTemplate restTemplate = new RestTemplate();
        return ResponseEntity.ok().body("Hello from minio");
    }


}
