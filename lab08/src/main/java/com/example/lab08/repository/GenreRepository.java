package com.example.lab08.repository;

import com.example.lab08.domain.Genre;

import java.util.List;

public interface GenreRepository {
    Genre getById(long id);
    List<Genre> getAll();
    Genre create(Genre genre);
    void update(Genre genre);
    void deleteElement(Genre genre);
    void deleteAll();
}
