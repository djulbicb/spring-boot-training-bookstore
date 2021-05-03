package com.training.bookstore.service;

import com.training.bookstore.convertor.BookConvertor;
import com.training.bookstore.model.Book;
import com.training.bookstore.model.BookEntity;
import com.training.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        for (BookEntity entity : bookRepository.findAll()) {
            books.add(BookConvertor.entityToDto(entity));
        }
        return books;
    }

    public Book save(Book book) {
        BookEntity save = bookRepository.save(BookConvertor.dtoToEntity(book));
        return BookConvertor.entityToDto(save);
    }

    public void deleteById(long bookId) {
        bookRepository.deleteById(bookId);
    }
    public Book findById(long bookId) {
        return BookConvertor.entityToDto(bookRepository.findById(bookId).get());
    }
}
