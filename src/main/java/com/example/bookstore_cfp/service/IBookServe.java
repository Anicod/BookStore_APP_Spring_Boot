package com.example.bookstore_cfp.service;

import com.example.bookstore_cfp.dto.BookDto;
import com.example.bookstore_cfp.model.BookM;

import java.util.List;

public interface IBookServe {
    BookM save(BookDto bookDto);
    List<BookM> getAllBook();
    BookM getBookById(Integer Id);
    BookM update(Integer Id, BookM bookM);
    void delete(Integer Id);
}
