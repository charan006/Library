package com.library.library_transaction_service.controller;

import com.library.library_transaction_service.model.LibraryTransaction;
import com.library.library_transaction_service.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("LibTransaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("allTransactions")
    public ResponseEntity<List<LibraryTransaction>> getAllTransactions(){
        return transactionService.getAllTransactions();
    }

//    @PostMapping("borrowBook")
//    public ResponseEntity<String> borrowBook( // some dto){
//        return transactionService.borrowBook();
//    }


}
