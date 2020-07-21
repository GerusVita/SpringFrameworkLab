package com.example.lab15.repository;

import com.example.lab15.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Long> {
    Genre findGenreByTitle(String name);
    void deleteGenreByTitle(String name);
}
