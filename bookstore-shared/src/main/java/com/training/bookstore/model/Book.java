package com.training.bookstore.model;


import java.util.Random;

public class Book {

    private String id;

    private String title;

    private String writer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public static Book random () {
        Random rnd = new Random();
        Book b = new Book();
        b.setTitle(rnd.nextInt(100) + "");
        b.setWriter(rnd.nextInt(100) + "");
        return b;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }
}
