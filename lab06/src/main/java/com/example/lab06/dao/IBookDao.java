package com.example.lab06.dao;

import com.example.lab06.domain.Book;

import java.util.ArrayList;
import java.util.List;

public interface IBookDao {
    List<Book> allBook();
    Book getOneById(long id);
    long create(Book book);
    int update(Book book);
    int deleteByID(long id);
    int deleteAll();
}
