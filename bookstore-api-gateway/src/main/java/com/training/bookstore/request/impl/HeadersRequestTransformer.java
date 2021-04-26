package com.training.bookstore.request.impl;

import com.training.bookstore.request.ProxyRequestTransformer;
import org.apache.http.client.methods.RequestBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Enumeration;
import java.util.Random;

public class HeadersRequestTransformer extends ProxyRequestTransformer {

    @Override
    public RequestBuilder transform(RequestBuilder requestBuilder, HttpServletRequest request) throws URISyntaxException, IOException {
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            if (headerName.equals("x-access-token")) {
                requestBuilder.addHeader(headerName, headerValue);
            }
        }

        requestBuilder.addHeader("bojan", new Random().nextInt(10) + "");
        return requestBuilder;
    }
}