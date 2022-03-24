package com.fmi.web.bookstore;

import com.fmi.web.bookstore.model.Book;
import com.fmi.web.bookstore.service.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookStoreApplication implements CommandLineRunner {

    @Autowired
    private Store bookStore;

    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello Spring!");
        bookStore.add(new Book("isbn1234", "Null Pointer 101", "Stoyan"));
    }
}
