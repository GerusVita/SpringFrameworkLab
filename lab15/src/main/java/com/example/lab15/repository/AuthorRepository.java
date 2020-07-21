package com.example.lab14.repository;

import com.example.lab14.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    Author findAuthorByFullName(String name);
    void deleteAuthorByFullName(String name);
}
