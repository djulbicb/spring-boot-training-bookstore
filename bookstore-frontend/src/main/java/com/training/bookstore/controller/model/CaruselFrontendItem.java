package com.training.bookstore.controller.model;

public class CaruselFrontendItem {
    private String url;
    private String title;
    private boolean active;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "CaruselFrontendItem{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}

