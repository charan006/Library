package com.library.book_service.controller;

import com.library.book_service.model.Book;
import com.library.book_service.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("getAllBooks")
    public ResponseEntity<List<Book>> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PostMapping("createBook")
    public ResponseEntity<String> createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }

    @GetMapping("getBook/{id}")
    public ResponseEntity<Book> getBook(@PathVariable int id){
        return bookService.getBookWithID(id);
    }

    @GetMapping("getBooks")
    public ResponseEntity<List<Book>> getBooks(@RequestBody List<Integer> listOfId){
        return bookService.getBooks(listOfId);
    }

    @PutMapping("updateBook")
    public ResponseEntity<String> updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }

    @DeleteMapping("deleteBook/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id){
        return bookService.deleteBookById(id);
    }



}
