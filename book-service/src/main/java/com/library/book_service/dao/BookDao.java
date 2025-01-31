package com.library.book_service.dao;


import com.library.book_service.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends JpaRepository<Book,Integer> {
}
