package com.example.bookstore_cfp.exception;

import com.example.bookstore_cfp.dto.BookResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookExceptionHandler {
 @ExceptionHandler(BookStoreException.class)
    ResponseEntity<BookResponseDto> bookException(Exception exception){
     BookResponseDto bookResponseDto = new BookResponseDto("exception while processing data", exception.getMessage());
     return new ResponseEntity<>(bookResponseDto, HttpStatus.OK);
 }

}
