package com.example.lab14.service;

import com.example.lab14.domain.Genre;
import com.example.lab14.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GenreService {
    @Autowired
    GenreRepository genreRepository;

    public void addGenre(Genre genre){
        genreRepository.save(genre);
    }
    public List<Genre> allGenre(){
        return genreRepository.findAll();
    }
    public Genre getOneById(Long id){
        return genreRepository.getOne(id);
    }
    public Genre getOneByTitle(String name){
        return genreRepository.findGenreByTitle(name);
    }
    public void deleteByTitle(String name){
        genreRepository.deleteGenreByTitle(name);
    }
    public void deleteById(Long id){
        genreRepository.deleteById(id);
    }
    public void deleteAll(){
        genreRepository.deleteAll();
    }
}
