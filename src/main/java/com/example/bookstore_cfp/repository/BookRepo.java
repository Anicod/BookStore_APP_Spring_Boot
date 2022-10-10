package com.example.bookstore_cfp.repository;

import com.example.bookstore_cfp.model.BookM;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<BookM, Integer > {

}
