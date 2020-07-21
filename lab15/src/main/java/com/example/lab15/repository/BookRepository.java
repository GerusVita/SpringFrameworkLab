package com.example.lab14.repository;


import com.example.lab14.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    Book findBookByTitle(String name);
    void deleteBookByTitle(String name);
    List<Book> getBooksByGenre_Id(Long id);
}
