package com.training.bookstore.model.resources.impl.home;

public class CaruselFrontendItem {
    private String imageUrl;
    private String url;
    private String title;
    private String description;
    private boolean active;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

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

