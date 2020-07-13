package com.example.lab08.repository;


import com.example.lab08.domain.Book;

import java.util.List;

public interface BookRepository {
    Book getById(long id);
    List<Book> getAll();
    Book create(Book book);
    void update(Book book);
    void deleteElement(Book book);
    void deleteAll();
}
