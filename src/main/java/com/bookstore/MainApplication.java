package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {

            bookstoreService.fetchAuthorById();
            bookstoreService.fetchAuthorFromBook();
        };
    }
}

/*
 * 
 * Use Java 8 Optional In Entities And Queries

Description: This application is an example of how is correct to use the Java 8 Optional in entities and queries.

Key points:

use the Spring Data built-in query-methods that return Optional (e.g., findById())
write your own queries that return Optional
use Optional in entities getters
in order to run different scenarios check the file, data-mysql.sql
 * 
 */
