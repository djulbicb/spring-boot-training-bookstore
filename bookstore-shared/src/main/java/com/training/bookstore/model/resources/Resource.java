package com.training.bookstore.model.resources;

public class Resource {
    public enum Type {
        GLOBAL, SHOPS_CASCADE, SHOPS_SITE
    }

    private String name;
    private String fileName;
    private Type type;
    private String category;
    private String storagePath;
    private String cloudPath;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStoragePath() {
        return storagePath;
    }

    public void setStoragePath(String storagePath) {
        this.storagePath = storagePath;
    }

    public String getCloudPath() {
        return cloudPath;
    }

    public void setCloudPath(String cloudPath) {
        this.cloudPath = cloudPath;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "name='" + name + '\'' +
                ", fileName='" + fileName + '\'' +
                ", type=" + type +
                ", category='" + category + '\'' +
                ", storagePath='" + storagePath + '\'' +
                ", cloudPath='" + cloudPath + '\'' +
                '}';
    }
}
