package com.library.library_transaction_service.feign;

import com.library.library_transaction_service.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("BOOK-SERVICE")
public interface BookFeign {

    @GetMapping("book/getAllBooks")
    public ResponseEntity<List<Book>> getAllBooks();

    @GetMapping("book/getBook/{id}")
    public ResponseEntity<Book> getBook(@PathVariable int id);

    @GetMapping("book/getBooks")
    public ResponseEntity<List<Book>> getBooks(@RequestBody List<Integer> listOfId);

    @PutMapping("book/updateBook")
    public ResponseEntity<String> updateBook(@RequestBody Book book);

}
