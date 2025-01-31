package com.library.book_service.service;

import com.library.book_service.dao.BookDao;
import com.library.book_service.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookDao bookDao;

    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }
}
