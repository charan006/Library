package com.library.library_transaction_service.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class LibraryTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(nullable = false)
    private int book_id;

    @Column(nullable = false)
    private int user_id;

    @Column(nullable = false)
    private LocalDate issueDate;
    private LocalDate returnDate;

    private String transactionStatus;

    public LibraryTransaction() {
    }

    public LibraryTransaction(String transactionStatus, LocalDate returnDate, LocalDate issueDate, int user_id, int book_id, int id) {
        this.transactionStatus = transactionStatus;
        this.returnDate = returnDate;
        this.issueDate = issueDate;
        this.user_id = user_id;
        this.book_id = book_id;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }



    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    @Override
    public String toString() {
        return "LibraryTransaction{" +
                "id=" + id +
                ", book_ids=" + book_id +
                ", user_id=" + user_id +
                ", issueDate=" + issueDate +
                ", returnDate=" + returnDate +
                ", transactionStatus='" + transactionStatus + '\'' +
                '}';
    }
}
