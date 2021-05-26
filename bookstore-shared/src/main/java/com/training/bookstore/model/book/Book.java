package com.training.bookstore.model.book;


import data.DataLibrary;

import javax.validation.constraints.NotEmpty;
import java.util.Random;

public class Book {

    private long id;

    @NotEmpty
    private String title;
    @NotEmpty
    private String writer;
    private String description;
    private String image;
    private double price;
    private double rating;

    public static Book empty(DataLibrary data) {
        Book book = new Book();
        book.setWriter(data.getName() + " " + data.getSurname());
        book.setTitle(data.getSentenceBound(4));
        book.setDescription(data.getParagraph());
        book.setImage(data.getImgUrl(400,300));
        return book;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public static Book random () {
        Random rnd = new Random();
        Book b = new Book();
        b.setTitle(rnd.nextInt(100) + "");
        b.setWriter(rnd.nextInt(100) + "");
        b.setPrice(rnd.nextDouble() * 10);
        b.setRating(rnd.nextDouble() * 70);
        return b;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }
}
