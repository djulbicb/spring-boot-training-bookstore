package com.training.bookstore.request;

import org.apache.http.client.methods.RequestBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URISyntaxException;

public abstract class ProxyRequestTransformer {

    public abstract RequestBuilder transform(RequestBuilder requestBuilder, HttpServletRequest request) throws URISyntaxException, IOException;
}