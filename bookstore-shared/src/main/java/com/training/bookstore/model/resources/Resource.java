package com.training.bookstore.model.resources;

public class Resource {
    public enum Type {
        GLOBAL, SHOP
    }

    private String name;
    private String category;
    private Type type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
