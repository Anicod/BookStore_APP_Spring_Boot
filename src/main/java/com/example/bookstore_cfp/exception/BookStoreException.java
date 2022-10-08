package com.example.bookstore_cfp.exception;

public class BookStoreException extends RuntimeException{
    public BookStoreException(String warning){
        super(warning);
    }
}
