package com.library.library_transaction_service.dao;

import com.library.library_transaction_service.model.LibraryTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDao extends JpaRepository<LibraryTransaction, Integer> {
}
