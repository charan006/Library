package com.library.book_service.dao;


import com.library.book_service.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookDao extends JpaRepository<Book,Integer> {
    Optional<Book> findByTitle(String title);
}
