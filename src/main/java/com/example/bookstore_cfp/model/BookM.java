package com.example.bookstore_cfp.model;

import com.example.bookstore_cfp.dto.BookDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.swing.*;

@Entity
public class BookM {
    @Id
    @GeneratedValue
    public Integer bookId;
    public String bookName;
    public String bookAuthor;
    public String bookDescription;
    public String bookImage;
    public Long bookPrice;
    public Long bookQuant;
    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public Long getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Long bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Long getBookQuant() {
        return bookQuant;
    }

    public void setBookQuant(Long bookQuant) {
        this.bookQuant = bookQuant;
    }

    public BookM(){

    }
    public BookM(BookDto bookDto){
        this.bookName = bookDto.bookName;
        this.bookAuthor = bookDto.bookAuthor;
        this.bookDescription = bookDto.bookDescription;
        this.bookImage = bookDto.bookImage;
        this.bookPrice = bookDto.bookPrice;
        this.bookQuant = bookDto.bookQuant;

    }

}
