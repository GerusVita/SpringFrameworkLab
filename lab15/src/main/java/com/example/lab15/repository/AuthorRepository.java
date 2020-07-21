package com.example.lab15.repository;

import com.example.lab15.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    Author findAuthorByFullName(String name);
    void deleteAuthorByFullName(String name);
}
