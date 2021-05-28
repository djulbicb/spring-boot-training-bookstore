package com.training.bookstore;

import com.training.bookstore.api.ApiEndpointConsumer;
import com.training.bookstore.model.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class BackendClient {

    private final String apiEndpoint;
    private final RestTemplate restTemplate;

    @Autowired
    public BackendClient(ApiEndpointConsumer endpointConsumer, RestTemplate restTemplate) {
        apiEndpoint = endpointConsumer.getBackend().getLocation();
        this.restTemplate = restTemplate;
    }

    public Book save(Book book) {
        return restTemplate.postForObject(apiEndpoint + "book/create", book, Book.class);
    }

    public List<Book> findAll() {
        ResponseEntity<List<Book>> responseEntity =
                restTemplate.exchange(apiEndpoint + "book",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Book>>() {
                        });
        return responseEntity.getBody();
    }

    public Book findBookById(long bookId) {
        return restTemplate.getForObject(apiEndpoint + "book/" + bookId, Book.class);
    }

    public void deleteBookById(Book book) {
        restTemplate.postForObject(apiEndpoint + "book/delete/" + book.getId(), null, Boolean.class);
    }
}
