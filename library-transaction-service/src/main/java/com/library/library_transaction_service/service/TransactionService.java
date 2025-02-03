package com.library.library_transaction_service.service;

import com.library.library_transaction_service.dao.TransactionDao;
import com.library.library_transaction_service.feign.BookFeign;
import com.library.library_transaction_service.model.Book;
import com.library.library_transaction_service.model.LibraryTransaction;
import com.library.library_transaction_service.model.ReturnDto;
import com.library.library_transaction_service.model.TransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    TransactionDao transactionDao;

    @Autowired
    BookFeign bookFeign;

    public ResponseEntity<List<LibraryTransaction>> getAllTransactions() {
        return new ResponseEntity<>(transactionDao.findAll(), HttpStatus.OK);
    }


    public ResponseEntity<String> borrowBook( TransactionDto request) {


        LibraryTransaction libraryTransaction=new LibraryTransaction();

        libraryTransaction.setUser_id(request.getUser_id());
        libraryTransaction.setBook_id(request.getBook_id());
        libraryTransaction.setIssueDate(request.getIssueDate());
        libraryTransaction.setReturnDate(null);
        libraryTransaction.setTransactionStatus("ISSUED");

        //validating if a copy of book is available to issue and then saving a record in transaction
        // updating available copies bookService
        try {

            if(bookFeign.getBook(request.getBook_id()).getBody() == null){
                return new ResponseEntity<>("BAD Request - Book Not found",HttpStatus.INTERNAL_SERVER_ERROR);
            }

            Book book = bookFeign.getBook(request.getBook_id()).getBody() ;

            if (book.getAvailableCopies() == 0){
                return new ResponseEntity<>("Book copies are not available",HttpStatus.CONFLICT);
            }

            //Update available copies in book Service
            book.setAvailableCopies(book.getAvailableCopies()-1);
            bookFeign.updateBook(book);
//            System.out.println(book);
            transactionDao.save(libraryTransaction);

            return ResponseEntity.ok("SUCCESS");

        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong.. Exception Details --> "+ e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> returnBook(ReturnDto request) {

        //update the transaction status
        LibraryTransaction libraryTransaction = transactionDao.findById(request.getId()).get();
        if(libraryTransaction == null){
            return new ResponseEntity<>("BAD Request - Transaction Not found",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        libraryTransaction.setReturnDate(request.getReturnDate());
        libraryTransaction.setTransactionStatus("RETURNED");

        // updating available copies bookService
        try {

            if(bookFeign.getBook(request.getBookId()).getBody() == null){
                return new ResponseEntity<>("BAD Request - Book Not found",HttpStatus.INTERNAL_SERVER_ERROR);
            }

            Book book = bookFeign.getBook(request.getBookId()).getBody() ;

            //Update available copies in book Service
            book.setAvailableCopies(book.getAvailableCopies()+1);
            bookFeign.updateBook(book);

            transactionDao.save(libraryTransaction);

            return ResponseEntity.ok("SUCCESS");

        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong.. Exception Details --> "+ e,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
