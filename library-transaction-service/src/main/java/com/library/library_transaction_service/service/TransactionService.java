package com.library.library_transaction_service.service;

import com.library.library_transaction_service.dao.TransactionDao;
import com.library.library_transaction_service.model.LibraryTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    TransactionDao transactionDao;

    public ResponseEntity<List<LibraryTransaction>> getAllTransactions() {

        return new ResponseEntity<>(transactionDao.findAll(), HttpStatus.OK);

    }
}
