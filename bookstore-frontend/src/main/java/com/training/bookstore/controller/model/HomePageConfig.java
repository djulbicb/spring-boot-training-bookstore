package com.training.bookstore.controller.model;

import java.util.List;

public class HomePageConfig {
    private String title;
    private String subtitle;
    private List<CaruselFrontendItem> items;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public List<CaruselFrontendItem> getItems() {
        return items;
    }

    public void setItems(List<CaruselFrontendItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "CaruselFrontend{" +
                "title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", items=" + items +
                '}';
    }
}
