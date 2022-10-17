package com.example.bookstore_cfp.service;

import com.example.bookstore_cfp.dto.BookDto;
import com.example.bookstore_cfp.exception.BookStoreException;
import com.example.bookstore_cfp.model.BookM;
import com.example.bookstore_cfp.model.UserM;
import com.example.bookstore_cfp.repository.BookRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BookServe implements IBookServe {
  @Autowired
    BookRepo bookRepo;

    @Override
    public BookM save(BookDto bookDto) {
       BookM bookM = new BookM(bookDto);
       return bookRepo.save(bookM);
    }

  @Override
  public List<BookM> getAllBook() {
    return bookRepo.findAll();
  }

  @Override
  public BookM getBookById(Integer Id) {
    BookM bookM = bookRepo.findById(Id).orElseThrow(()-> new BookStoreException("data not exsist please check and try again"));
    return bookM;
  }

  @Override
  public BookM update(Integer Id, BookM bookM) {
    BookM bookM1 = bookRepo.findById(Id).orElseThrow(()->new BookStoreException("sorry data not exsist try again"));
    if(bookM1 != null){
      bookM1.setBookName(bookM.getBookName());
      bookM1.setBookAuthor(bookM.getBookAuthor());
      bookM1.setBookDescription(bookM.getBookDescription());
      bookM1.setBookImage(bookM.getBookImage());
      bookM1.setBookPrice(bookM.getBookPrice());
      bookM1.setBookPrice(bookM.getBookQuant());
      return bookRepo.save(bookM1);
    }
    return bookM1;
  }

  @Override
  public void delete(Integer Id) {
      if (bookRepo.existsById(Id)){
        bookRepo.deleteById(Id);
        log.info("book data deleted successfully");
      }
      else {
        log.info("book data does not exsit");
        throw new BookStoreException("that data is not available!!!");
      }

  }

  @Override
  public List<BookM> bookSort() {
    return bookRepo.sortedPrice();
  }

}
