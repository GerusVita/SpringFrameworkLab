package com.example.lab14.repository;

import com.example.lab14.domain.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderRepository extends JpaRepository<Reader,Long> {
    Reader findReaderByName(String name);
    void deleteReaderByName(String name);
}
