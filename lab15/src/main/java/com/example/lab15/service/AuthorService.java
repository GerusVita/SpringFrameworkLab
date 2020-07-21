package com.example.lab14.service;

import com.example.lab14.domain.Author;
import com.example.lab14.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    public void addAuthor(Author author){
        authorRepository.save(author);
    }
    public List<Author> allAuthors(){
        return authorRepository.findAll();
    }
    public Author getOneByName(String name){
        return authorRepository.findAuthorByFullName(name);
    }
    public Author getOneById(Long id){
        return authorRepository.getOne(id);
    }
    public void deleteByName(String name){
        authorRepository.deleteAuthorByFullName(name);
    }
    public void deleteById(Long id){
        authorRepository.deleteById(id);
    }
    public void deleteAll(){
        authorRepository.deleteAll();
    }
}
