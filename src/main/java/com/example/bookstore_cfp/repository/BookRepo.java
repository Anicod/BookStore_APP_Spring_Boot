package com.example.bookstore_cfp.repository;

import com.example.bookstore_cfp.model.BookM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepo extends JpaRepository<BookM, Integer > {
@Query(value = "select * from bookm order by book_price", nativeQuery = true)
    List<BookM> sortedPrice();
}
