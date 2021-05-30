package com.training.bookstore.model.resources.impl.home;

import java.util.List;

public class FooterColumn {
    String title;
    List<FooterColumnItem> links;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<FooterColumnItem> getLinks() {
        return links;
    }

    public void setLinks(List<FooterColumnItem> links) {
        this.links = links;
    }
}
