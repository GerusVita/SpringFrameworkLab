package com.example.lab08.repository;

import com.example.lab08.domain.Author;

import java.util.List;

public interface AuthorRepository {
    Author getById(long id);
    List<Author> getAll();
    Author create(Author author);
    void update(Author author);
    void deleteElement(Author author);
    void deleteAll();
}
