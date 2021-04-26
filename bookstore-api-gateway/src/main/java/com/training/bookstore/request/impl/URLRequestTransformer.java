package com.training.bookstore.request.impl;
import com.training.bookstore.ApiGatewayEndpoint;
import com.training.bookstore.Endpoint;
import com.training.bookstore.EndpointConfiguration;
import com.training.bookstore.request.ProxyRequestTransformer;
import org.apache.http.client.methods.RequestBuilder;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

public class URLRequestTransformer extends ProxyRequestTransformer {

    private final EndpointConfiguration endpointConfiguration;

    public URLRequestTransformer(EndpointConfiguration endpointConfiguration) {
        this.endpointConfiguration = endpointConfiguration;
    }

    @Override
    public RequestBuilder transform(RequestBuilder rb, HttpServletRequest request) throws URISyntaxException {
        String requestURI = request.getRequestURI();
        URI uri;
        if (request.getQueryString() != null && !request.getQueryString().isEmpty()) {
            uri = new URI(getServiceUrl(requestURI, request) + "?" + request.getQueryString());
        } else {
            uri = new URI(getServiceUrl(requestURI, request));
        }

        rb.setUri(uri);
        return rb;
    }

    private String getServiceUrl(String requestURI, HttpServletRequest httpServletRequest) {
        Optional<Endpoint> found = Optional.empty();
        for (Endpoint e : endpointConfiguration.getEndpoints()) {
            if (requestURI.matches(e.getPath()) && e.getMethod() == RequestMethod.valueOf(httpServletRequest.getMethod())) {
                found = Optional.of(e);
                break;
            }
        }
        Endpoint endpoint = found.orElseThrow(() -> new RuntimeException("runtime"));
        return endpoint.getLocation() + requestURI;
    }
}