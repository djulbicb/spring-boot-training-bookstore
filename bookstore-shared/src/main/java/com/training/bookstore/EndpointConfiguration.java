package com.training.bookstore;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableConfigurationProperties()
public class EndpointConfiguration implements WebMvcConfigurer {

    private final Map<String, Endpoint> endpointMap;
    private final String FRONTEND = "frontend";
    private final String BACKEND = "backend";
    private final String FILES = "files";
    private final String MINIO = "minio";
    private final String API_GATEWAY = "api-gateway";


    @Autowired
    public EndpointConfiguration(ApiGatewayProperties endpoints) {
        this.endpointMap = convertEndpointsToMap(endpoints);
    }

    private Map<String, Endpoint> convertEndpointsToMap(ApiGatewayProperties endpoints) {
        Map<String, Endpoint> endpointMap = new HashMap<>();
        for (Endpoint endpoint : endpoints.getEndpoints()) {
            endpointMap.put(endpoint.getName(), endpoint);
        }
        return endpointMap;
    }

    public Endpoint getFrontend() {
        return endpointMap.get(FRONTEND);
    }

    public Endpoint getBackend() {
        return endpointMap.get(BACKEND);
    }

    public Endpoint getMinio() {
        return endpointMap.get(MINIO);
    }

    public Endpoint getFiles() {
        return endpointMap.get(FILES);
    }

    public Endpoint getApiGateway() {
        return endpointMap.get(API_GATEWAY);
    }

    public Collection<Endpoint> getEndpoints() {
        return endpointMap.values();
    }
}
