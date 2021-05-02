package com.training.bookstore;

import com.training.bookstore.api.ApiEndpointConsumer;
import com.training.bookstore.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class BackendClient {

    private final ApiEndpointConsumer endpointConsumer;

    @Autowired
    public BackendClient(ApiEndpointConsumer endpointConsumer) {
        this.endpointConsumer = endpointConsumer;
    }

    public void save(Book book) {

    }

    public List<Book> findAll() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Book>> responseEntity =
                restTemplate.exchange(endpointConsumer.getBackend().getLocation() + "book",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Book>>() {
                        });

       return responseEntity.getBody();

    }
}
