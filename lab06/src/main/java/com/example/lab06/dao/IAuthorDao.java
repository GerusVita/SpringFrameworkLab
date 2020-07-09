package com.example.lab06.dao;

import com.example.lab06.domain.Author;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.List;

public interface IAuthorDao {
    SimpleJdbcInsert simpleJdbcInsert = null;
    List<Author> allAuthor();
    Author getOneById(long id);
    long create(Author author);
    int update(Author author);
    int deleteById(long id);
    int deleteAll();
}
