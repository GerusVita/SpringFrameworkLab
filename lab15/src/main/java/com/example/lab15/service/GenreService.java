package com.example.lab15.service;

import com.example.lab15.domain.Genre;
import com.example.lab15.repository.GenreRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GenreService {
    @Autowired
    GenreRepository genreRepository;

    public void addGenre(Genre genre) {
        genreRepository.save(genre);
    }

    public List<Genre> allGenre() {
        return genreRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Genre getOneById(Long id) {
        Genre genre = genreRepository.getOne(id);
        Hibernate.initialize(genre.getBooks());
        return genre;
    }

    public Genre getOneByTitle(String name) {
        return genreRepository.findGenreByTitle(name);
    }

    public void deleteByTitle(String name) {
        genreRepository.deleteGenreByTitle(name);
    }

    public void deleteById(Long id) {
        genreRepository.deleteById(id);
    }

    public void deleteAll() {
        genreRepository.deleteAll();
    }
}
