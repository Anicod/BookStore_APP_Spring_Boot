package com.example.bookstore_cfp.repository;

import com.example.bookstore_cfp.model.UserM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<UserM, Integer> {
    @Query(value = "select * from userm where first_name=:name", nativeQuery = true)
    UserM getUserMSByFirstName(String name);
    @Query(value = "select * from userm where email=:userEmail and password=:userPassword", nativeQuery = true)
    UserM getUserMBynameAndPassword(String userEmail, String userPassword);
}
