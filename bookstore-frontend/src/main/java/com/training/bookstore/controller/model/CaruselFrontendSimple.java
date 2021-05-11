package com.training.bookstore.controller.model;

import com.google.gson.annotations.SerializedName;

public class CaruselFrontendSimple {
    //@SerializedName()
    private int numberOfPics;
    private String title;
    private String subtitle;

    public int getNumberOfPics() {
        return numberOfPics;
    }

    public void setNumberOfPics(int numberOfPics) {
        this.numberOfPics = numberOfPics;
    }

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

    @Override
    public String toString() {
        return "CaruselFrontend{" +
                "numberOfPics='" + numberOfPics + '\'' +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                '}';
    }
}
