package com.library.book_service.service;

import com.library.book_service.dao.BookDao;
import com.library.book_service.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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


    public ResponseEntity<List<Book>> getBooks(List<Integer> listOfId) {
        List<Book> temp = new ArrayList<>();
        for(int i:listOfId){
            temp.add(getBookWithID(i).getBody());
        }
        return new ResponseEntity<>(temp,HttpStatus.OK);

    }

    public ResponseEntity<String> updateBook(Book book) {

        if(getBookWithID(book.getId()).getBody() == null){
            return new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
        }
        bookDao.save(book);
        return ResponseEntity.ok("SUCCESS");
    }

    public ResponseEntity<String> deleteBookById(int id) {
        if(getBookWithID(id) == null){
            return new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
        }
        try {
            bookDao.deleteById(id);
            return ResponseEntity.ok("SUCCESS - Record Deleted");
        }catch (Exception e) {
        return new ResponseEntity<>("Delete failed: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }

    public ResponseEntity<String> createBook(Book book) {
        if(book == null){
            return new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
        }

        //Check if same book exists in db
        Optional<Book> existingBook = bookDao.findByTitle(book.getTitle());
        if (existingBook.isPresent()) {
            return new ResponseEntity<>("Book with this title already exists", HttpStatus.CONFLICT);
        }

        bookDao.save(book);
        return ResponseEntity.ok("SUCCESS - Book created");
    }
}
