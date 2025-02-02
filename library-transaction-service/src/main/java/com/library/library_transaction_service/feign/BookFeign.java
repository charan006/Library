package com.library.library_transaction_service.feign;

import com.library.library_transaction_service.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "BOOK-SERVICE")
public interface BookFeign {

    @GetMapping("getAllBooks")
    public ResponseEntity<List<Book>> getAllBooks();

    @PostMapping("createBook")
    public ResponseEntity<String> createBook(@RequestBody Book book);

    @GetMapping("getBook/{id}")
    public ResponseEntity<Book> getBook(@PathVariable int id);

    @GetMapping("getBooks")
    public ResponseEntity<List<Book>> getBooks(@RequestBody List<Integer> listOfId);

    @PutMapping("updateBook")
    public ResponseEntity<String> updateBook(@RequestBody Book book);

    @DeleteMapping("deleteBook/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id);


}
