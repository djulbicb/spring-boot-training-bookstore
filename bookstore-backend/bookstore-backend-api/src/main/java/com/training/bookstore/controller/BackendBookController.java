package com.training.bookstore.controller;

import com.training.bookstore.model.Book;
import com.training.bookstore.service.BookService;
import data.DataLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/backend/book")
public class
BackendBookController {

    private final BookService bookService;
    private final DataLibrary data;

    @Autowired
    public BackendBookController(BookService bookService, DataLibrary dataLibrary) {
        this.bookService = bookService;
        this.data = dataLibrary;
    }

    @GetMapping("")
    public List<Book> getIndex() {
        return bookService.findAll();
    }

    @GetMapping("/{bookId}")
    public Book getBookById(@PathVariable("bookId") long bookId) {
        return bookService.findById(bookId);
    }

    @PostMapping("/create")
    public Book saveBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PostMapping("/delete/{bookId}")
    public void deleteBook(@PathVariable long bookId) {
        bookService.deleteById(bookId);
    }

    @GetMapping("test")
    public String saveTestBook() {
        for (int i = 0; i < 5; i++) {
            Book book =Book.empty(data);
            bookService.save(book);
        }
        return "Book random saved";
    }
}
