package com.training.bookstore.resources;

public abstract class Resource {
    public enum Type {
        SHOP, GLOBAL
    }

    public abstract Type getType();
    public abstract String getName();
    public abstract String getVersion();
    public abstract String getPath();
}
