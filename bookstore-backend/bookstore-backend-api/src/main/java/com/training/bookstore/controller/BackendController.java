package com.training.bookstore.controller;

import com.training.bookstore.model.Book;
import com.training.bookstore.model.BookEntity;
import com.training.bookstore.repository.BookRepository;
import com.training.bookstore.service.BookService;
import data.DataLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/backend/book")
public class
BackendController {

    private final BookService bookService;
    private final DataLibrary data;

    @Autowired
    public BackendController(BookService bookService, DataLibrary dataLibrary) {
        this.bookService = bookService;
        this.data = dataLibrary;
    }

    @GetMapping("")
    public List<Book> getIndex() {
        return bookService.findAll();
    }

    @PostMapping("")
    public Book saveBook(Book book) {
        return bookService.save(book);
    }

    @GetMapping("test")
    public String saveTestBook() {
        Book book = new Book();
        book.setWriter(data.getName() + " " + data.getSurname());
        book.setTitle(data.getSentenceBound(4));
        bookService.save(book);
        return "Book random saved";
    }
}
