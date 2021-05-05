package com.training.bookstore.model.statics;

import java.util.Random;

public class StaticHtmlPage {
    private String keywords;
    private String description;
    private String title;
    private String h1;
    private String content;

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getH1() {
        return h1;
    }

    public void setH1(String h1) {
        this.h1 = h1;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static StaticHtmlPage empty () {
        Random rnd = new Random();

        StaticHtmlPage page = new StaticHtmlPage();
        page.setTitle("Title: " + rnd.nextInt(100));
        page.setContent("Content: " + rnd.nextInt(100));
        page.setH1("H1: " + rnd.nextInt(100));
        page.setDescription("Description: " + rnd.nextInt(100));
        page.setKeywords("Keywords: " + rnd.nextInt(100));
        return page;
    }
}
