package com.example.lab08.repository;

import com.example.lab08.domain.Reader;

import java.util.List;

public interface ReaderRepository {
    Reader getById(long id);
    List<Reader> getAll();
    Reader create(Reader reader);
    void update(Reader reader);
    void deleteElement(Reader reader);
    void deleteAll();
}
