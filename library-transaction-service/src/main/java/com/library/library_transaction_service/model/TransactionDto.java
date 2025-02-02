package com.library.library_transaction_service.model;

import java.time.LocalDate;

public class TransactionDto {

//    String transactionStatus, LocalDate returnDate, java.time.LocalDate issueDate, int user_id, int book_id, int id

    private int user_id;
    private int book_id;
    private LocalDate issueDate;

    public TransactionDto() {
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
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


    @Override
    public String toString() {
        return "TransactionDto{" +
                ", user_id=" + user_id +
                ", book_id=" + book_id +
                ", issueDate=" + issueDate +
                '}';
    }
}
