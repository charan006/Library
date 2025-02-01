package com.library.book_service.service;

import com.library.book_service.dao.BookDao;
import com.library.book_service.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookDao bookDao;

    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookDao.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Book> getBookWithID(int id) {
        return new ResponseEntity<>(bookDao.findById(id).get(), HttpStatus.OK);
    }



}
