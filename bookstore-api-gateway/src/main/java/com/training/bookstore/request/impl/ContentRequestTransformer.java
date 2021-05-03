package com.training.bookstore.request.impl;

import com.training.bookstore.request.ProxyRequestTransformer;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.stream.Collectors;

@Component
public class ContentRequestTransformer extends ProxyRequestTransformer {

    @Override
    public RequestBuilder transform(RequestBuilder requestBuilder, HttpServletRequest request) throws URISyntaxException, IOException {
        String requestContent = request.getReader().lines().collect(Collectors.joining(""));
        if (!requestContent.isEmpty()) {
            StringEntity entity = new StringEntity(requestContent, ContentType.APPLICATION_JSON);
            requestBuilder.setEntity(entity);
        }

        return requestBuilder;
    }
}