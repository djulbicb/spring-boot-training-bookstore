package com.training.bookstore.api;

import com.pocketknife.resource.JsonToClassResourceReader;
import org.springframework.stereotype.Component;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class ApiEndpointConsumer extends JsonToClassResourceReader<List<Endpoint>> {
    private final List<Endpoint> endpoints;

    private Endpoint backend;
    private Endpoint frontend;

    public Endpoint getBackend() {
        return backend;
    }

    public Endpoint getFrontend() {
        return frontend;
    }

    public ApiEndpointConsumer() {
        Type type = new TypeToken<List<Endpoint>>() {}.getType();
        List<Endpoint> endpoints = readConfig(type);

        for (Endpoint endpoint : endpoints) {
            final String endpointName = endpoint.getName();
            switch (endpointName) {
                case "backend" :
                    backend = endpoint;
                    break;
                case "frontend" :
                    frontend = endpoint;
                    break;
            }
        }


        this.endpoints = endpoints;
    }


    @Override
    public String getResourceFilePath() {
        return "api-endpoints.json";
    }
}
