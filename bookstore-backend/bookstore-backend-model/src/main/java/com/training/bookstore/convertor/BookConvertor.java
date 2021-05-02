package com.training.bookstore.convertor;

import com.training.bookstore.model.BookEntity;
import com.training.bookstore.model.Book;

public class BookConvertor {

    public static Book entityToDto (BookEntity entity){
        Book book = new Book();
        book.setId(entity.getId());
        book.setTitle(entity.getTitle());
        book.setWriter(entity.getWriter());
        return book;
    }

    public static BookEntity dtoToEntity (Book book){
        BookEntity entity = new BookEntity();
        entity.setId(book.getId());
        entity.setTitle(book.getTitle());
        entity.setWriter(book.getWriter());
        return entity;
    }
}
