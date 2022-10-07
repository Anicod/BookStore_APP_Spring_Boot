package com.example.bookstore_cfp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class BookstoreCfpApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreCfpApplication.class, args);
        log.info("bookstore is running");
    }

}
