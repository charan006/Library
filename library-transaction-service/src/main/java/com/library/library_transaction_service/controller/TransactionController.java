package com.library.library_transaction_service.controller;

import com.library.library_transaction_service.model.LibraryTransaction;
import com.library.library_transaction_service.model.ReturnDto;
import com.library.library_transaction_service.model.TransactionDto;
import com.library.library_transaction_service.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("borrowBook")
    public ResponseEntity<String> borrowBook(@RequestBody TransactionDto request){
        return transactionService.borrowBook(request);
    }

    @PostMapping("returnBook")
    public ResponseEntity<String> returnBook(@RequestBody ReturnDto request){
        return transactionService.returnBook(request);
    }

}
