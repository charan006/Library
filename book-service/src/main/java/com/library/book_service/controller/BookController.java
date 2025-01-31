package com.library.book_service.controller;

import com.library.book_service.model.Book;
import com.library.book_service.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("getBooks")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }


}
