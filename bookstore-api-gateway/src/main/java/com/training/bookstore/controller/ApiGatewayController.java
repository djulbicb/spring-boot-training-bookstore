package com.training.bookstore.controller;

import com.djulb.string.StringUtil;
import com.training.bookstore.request.ProxyRequestTransformer;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RequestMapping("/api/**")
@RestController
public class ApiGatewayController {

    List<ProxyRequestTransformer> requestTransformers;

    @Autowired
    public ApiGatewayController(List<ProxyRequestTransformer> requestTransformers) {
        this.requestTransformers = requestTransformers;
    }

    @RequestMapping("")
    public ResponseEntity<String> forwardRequest(HttpServletRequest request) throws IOException, URISyntaxException {
        HttpClient client=new DefaultHttpClient();

        RequestBuilder builder = RequestBuilder.create(request.getMethod());
        for (ProxyRequestTransformer transformer : requestTransformers) {
            transformer.transform(builder, request);
        }
        HttpEntity entity = client.execute(builder.build()).getEntity();
        return ResponseEntity.ok(StringUtil.inputStreamToString(entity.getContent()));
    }
}
