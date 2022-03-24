package com.fmi.web.bookstore.repository;

import com.fmi.web.bookstore.model.Book;

import java.util.List;


public interface CRUD {

    void add(Book book);

    Book update(Book book);

    void remove(String isbn);

    Book getByKey(String isbn);

    List<Book> getAll();

    void clear();
}