package com.training.bookstore.controller.admin;

import com.training.bookstore.BackendClient;
import com.training.bookstore.model.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminBookController {

    @Autowired
    BackendClient backendClient;

    @GetMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", backendClient.findAll());
        return "/admin/book/books";
    }

    @GetMapping("/book/create")
    public String getBookCreate(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "/admin/book/create";
    }

    @PostMapping("/book/create")
    public String postBookCreate(@ModelAttribute("book") @Valid Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("book", book);
            return "/admin/book/create";
        }
        Book save = backendClient.save(book);
        return "redirect:/admin/books";
    }

    @GetMapping("/book/view/{bookId}")
    public String getViewBook(@PathVariable("bookId") long bookId, Model model) {
        model.addAttribute("book", backendClient.findBookById(bookId));
        return "/admin/book/view";
    }

    @PostMapping("/book/delete/{bookId}")
    public String deleteBook(@PathVariable("bookId") long bookId) {
        Book book = new Book();
        book.setId(bookId);
        backendClient.deleteBookById(book);
        return "redirect:/admin/books";
    }

    @GetMapping("/book/update/{bookId}")
    public String getUpdateBook(@PathVariable("bookId") long bookId, Model model) {
        model.addAttribute("book", backendClient.findBookById(bookId));
        return "/admin/book/create";
    }

    @PostMapping("/book/update/{bookId}")
    public String updateBook(@PathVariable("bookId") long bookId, @ModelAttribute @Valid Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("book", book);
            return "/admin/book/create";
        }
        backendClient.save(book);
        return "redirect:/admin/books" + book.getId();
    }

}
