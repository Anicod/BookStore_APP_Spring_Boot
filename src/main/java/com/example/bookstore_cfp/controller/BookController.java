package com.example.bookstore_cfp.controller;

import com.example.bookstore_cfp.dto.BookDto;
import com.example.bookstore_cfp.dto.BookResponseDto;
import com.example.bookstore_cfp.dto.ResponseUserDto;
import com.example.bookstore_cfp.model.BookM;
import com.example.bookstore_cfp.service.IBookServe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class BookController {
    @Autowired
    IBookServe iBookServe;
    @PostMapping("/addbook")
    ResponseEntity<BookResponseDto> addBook(@RequestBody BookDto bookDto){
        BookM bookM = iBookServe.save(bookDto);
        BookResponseDto bookResponseDto = new BookResponseDto(bookM, "Book added successfully");
        return new ResponseEntity<>(bookResponseDto, HttpStatus.OK);
    }
    @GetMapping("/getallbook")
    ResponseEntity<BookResponseDto> getAllBook(){
        List<BookM> bookMList = iBookServe.getAllBook();
       BookResponseDto bookResponseDto = new BookResponseDto(bookMList, "all list of book");
        return new ResponseEntity<>(bookResponseDto, HttpStatus.OK);

    }
    @GetMapping("/bookbyid")
    ResponseEntity<BookResponseDto> getBookId(Integer Id){
        BookM bookM = iBookServe.getBookById(Id);
        if(bookM.bookId.equals(Id)){
            log.info("user exsit in database");
        }
        else {
            log.info("user not found");
        }
        BookResponseDto bookResponseDto = new BookResponseDto(bookM, "get book by id");
        return new ResponseEntity<>(bookResponseDto, HttpStatus.OK);
    }
    @PutMapping("update/{Id}")
    ResponseEntity<BookResponseDto> updateById(@PathVariable Integer Id, @RequestBody BookDto bookDto){
        BookM bookM = new BookM(bookDto);
        BookM updateBook = iBookServe.update(Id, bookM);
        BookResponseDto bookResponseDto = new BookResponseDto(updateBook, "book data updated successfully");
        return new ResponseEntity<>(bookResponseDto, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{Id}")
    String deleteBook(@PathVariable Integer Id){
        iBookServe.delete(Id);
        return "book deleted successfully";
    }


}
