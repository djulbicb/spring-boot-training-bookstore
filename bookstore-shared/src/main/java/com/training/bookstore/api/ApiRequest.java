package com.training.bookstore.api;

public class ApiRequest<T> {

    enum Type {
        GET, POST, DELETE, PUT
    }

    private T object;
    private Type type;

    private ApiRequest() {

    }

    public T getObject() {
        return object;
    }

    public Type getType() {
        return type;
    }

    public static <T> ApiRequest get(T object) {
        ApiRequest<Object> request = new ApiRequest<>();
        request.object = object;
        request.type = Type.GET;
        return request;
    }

    public static <T> ApiRequest delete(T object) {
        ApiRequest<Object> request = new ApiRequest<>();
        request.object = object;
        request.type = Type.DELETE;
        return request;
    }

    public static <T> ApiRequest post(T object) {
        ApiRequest<Object> request = new ApiRequest<>();
        request.object = object;
        request.type = Type.POST;
        return request;
    }

    public static <T> ApiRequest put(T object) {
        ApiRequest<Object> request = new ApiRequest<>();
        request.object = object;
        request.type = Type.PUT;
        return request;
    }

}
