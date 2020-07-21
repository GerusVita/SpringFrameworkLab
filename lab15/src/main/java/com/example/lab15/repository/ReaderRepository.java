package com.example.lab15.repository;

import com.example.lab15.domain.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderRepository extends JpaRepository<Reader,Long> {
    Reader findReaderByName(String name);
    void deleteReaderByName(String name);
}
