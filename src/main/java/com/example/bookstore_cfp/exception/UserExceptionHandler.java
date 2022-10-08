package com.example.bookstore_cfp.exception;

import com.example.bookstore_cfp.dto.ResponseUserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(BookStoreException.class)
    ResponseEntity<ResponseUserDto> userExcp(Exception exception){
        ResponseUserDto responseUserDto = new ResponseUserDto("exception while processing data", exception.getMessage());
        return new ResponseEntity<>(responseUserDto, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ResponseUserDto> validationExcep(Exception exception){
        ResponseUserDto responseUserDto = new ResponseUserDto("exception while processing data", exception.getMessage());
        return new ResponseEntity<>(responseUserDto, HttpStatus.BAD_REQUEST);
    }
}
