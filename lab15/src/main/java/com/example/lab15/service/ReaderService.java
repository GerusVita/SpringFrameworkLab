package com.example.lab15.service;

import com.example.lab15.domain.Reader;
import com.example.lab15.repository.ReaderRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReaderService {
    @Autowired
    private ReaderRepository readerRepository;

    public void addReader(Reader reader) {
        readerRepository.save(reader);
    }

    public List<Reader> allReader() {
        return readerRepository.findAll();
    }

    public Reader getOneByName(String name) {
        return readerRepository.findReaderByName(name);
    }

    @Transactional(readOnly = true)
    public Reader getOneById(Long id) {
        Reader reader = readerRepository.getOne(id);
        Hibernate.initialize(reader.getComment());
        return reader;
    }

    public void deleteOneById(Long id) {
        readerRepository.deleteById(id);
    }

    public void deleteOneByName(String name) {
        readerRepository.findReaderByName(name);
    }

    public void deleteAll() {
        readerRepository.deleteAll();
    }
}
