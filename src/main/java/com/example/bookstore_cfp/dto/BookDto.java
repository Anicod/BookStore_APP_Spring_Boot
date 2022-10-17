package com.example.bookstore_cfp.dto;

public class BookDto {
    public String bookName;
    public String bookAuthor;
    public String bookDescription;
    public String bookImage;
    public Long bookPrice;
    public Long bookQuant;

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

    public Long getBookQuant() {
        return bookQuant;
    }

    public void setBookQuant(Long bookQuant) {
        this.bookQuant = bookQuant;
    }

    public void setBookPrice(Long bookPrice) {
        this.bookPrice = bookPrice;
    }

    public BookDto(String bookName, String bookAuthor, String bookDescription, String bookImage, Long bookPrice, Long bookQuant) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookDescription = bookDescription;
        this.bookImage = bookImage;
        this.bookPrice = bookPrice;
        this.bookQuant = bookQuant;
    }
}
