package com.example.bookstore_cfp.dto;

public class BookResponseDto {
    public Object bookData;
    public String bookMeaaage;

    public Object getBookData() {
        return bookData;
    }

    public void setBookData(Object bookData) {
        this.bookData = bookData;
    }

    public String getBookMeaaage() {
        return bookMeaaage;
    }

    public void setBookMeaaage(String bookMeaaage) {
        this.bookMeaaage = bookMeaaage;
    }

    public BookResponseDto(Object bookData, String bookMeaaage) {
        this.bookData = bookData;
        this.bookMeaaage = bookMeaaage;
    }
}
