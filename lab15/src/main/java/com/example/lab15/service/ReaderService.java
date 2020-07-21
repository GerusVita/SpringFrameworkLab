package com.example.lab14.service;

import com.example.lab14.domain.Reader;
import com.example.lab14.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReaderService {
    @Autowired
    private ReaderRepository readerRepository;

    public void addReader(Reader reader){
        readerRepository.save(reader);
    }
    public List<Reader> allReader(){
        return readerRepository.findAll();
    }
    public Reader getOneByName(String name){
        return readerRepository.findReaderByName(name);
    }
    public Reader getOneById(Long id){
        return readerRepository.getOne(id);
    }
    public void deleteOneById(Long id){
        readerRepository.deleteById(id);
    }
    public void deleteOneByName(String name){
        readerRepository.findReaderByName(name);
    }
    public void deleteAll(){
        readerRepository.deleteAll();
    }
}
