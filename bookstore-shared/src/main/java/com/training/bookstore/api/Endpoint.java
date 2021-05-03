package com.training.bookstore.api;

import org.apache.commons.text.StringSubstitutor;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

public class Endpoint {

    private String name;
    private String api;
    private String regex;
    private String url;
    private RequestMethod method;
    private String location;
    private int port;
    private String username;
    private String password;

    Endpoint() {
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Endpoint(String location) {
        this.location = location;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public RequestMethod getMethod() {
        return method;
    }

    public void setMethod(RequestMethod method) {
        this.method = method;
    }


    public String getLocation() {
        Map<String, Object> values = new HashMap<>();
        values.put("url", url);
        values.put("port", port);
        values.put("api", api);

        StringSubstitutor sub = new StringSubstitutor(values);
        sub.setEnableSubstitutionInVariables(true);
        String resultLocation = sub.replace(location);

        return resultLocation;
    }

    public String getHost () {
        Map<String, Object> values = new HashMap<>();
        values.put("url", url);
        values.put("port", port);

        StringSubstitutor sub = new StringSubstitutor(values);
        sub.setEnableSubstitutionInVariables(true);
        String resultLocation = sub.replace("http://${url}:${port}");

        return resultLocation;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Endpoint{" +
                "path='" + api + '\'' +
                ", method=" + method +
                ", location='" + location + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

