package com.training.bookstore.model.resources.impl.home;

import java.util.List;

public class HomePageConfig {
    private String title;
    private String subtitle;
    private List<CaruselFrontendItem> caruselSlides;

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

    public List<CaruselFrontendItem> getCaruselSlides() {
        return caruselSlides;
    }

    public void setCaruselSlides(List<CaruselFrontendItem> caruselSlides) {
        this.caruselSlides = caruselSlides;
    }

    @Override
    public String toString() {
        return "CaruselFrontend{" +
                "title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", items=" + caruselSlides +
                '}';
    }
}
