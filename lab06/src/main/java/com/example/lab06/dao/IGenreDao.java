package com.example.lab06.dao;


import com.example.lab06.domain.Genre;

import java.util.List;

public interface IGenreDao {
    List<Genre> allGenre();
    Genre getOneById(long id);
    long create(Genre author);
    int update(Genre genre);
    int deleteById(long id);
    int deleteAll();
}
