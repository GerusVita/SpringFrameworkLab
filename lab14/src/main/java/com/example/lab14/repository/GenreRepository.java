package com.example.lab14.repository;

import com.example.lab14.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Long> {
    Genre findGenreByTitle(String name);
    void deleteGenreByTitle(String name);
}
