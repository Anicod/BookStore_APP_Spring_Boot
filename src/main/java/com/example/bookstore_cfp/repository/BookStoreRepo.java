package com.example.bookstore_cfp.repository;

import com.example.bookstore_cfp.model.UserM;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookStoreRepo extends JpaRepository<UserM, Integer> {
    
}
