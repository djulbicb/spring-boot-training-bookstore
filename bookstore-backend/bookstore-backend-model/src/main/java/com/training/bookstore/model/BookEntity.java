package com.training.bookstore.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Random;

@Entity
@Table(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String writer;

    @Column(columnDefinition="text", length=10000)
    private String description;

    private String image;
    private double price;
    private double rating;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static BookEntity random () {
        Random rnd = new Random();
        BookEntity b = new BookEntity();
        b.setTitle(rnd.nextInt(100) + "");
        b.setWriter(rnd.nextInt(100) + "");
        b.setDescription(rnd.nextInt(100) + "");
        b.setImage(rnd.nextInt(100) + "");
        return b;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
