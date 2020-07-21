package com.example.lab15.service;

import com.example.lab15.domain.Book;
import com.example.lab15.domain.Commentary;
import com.example.lab15.repository.BookRepository;
import com.example.lab15.repository.CommentaryRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentaryService {
    @Autowired
    CommentaryRepository commentaryRepository;
    @Autowired
    BookRepository bookRepository;

    public void addComment(Commentary commentary) {
        Book book = bookRepository.getOne(commentary.getBook().getId());
        commentary.setBook(book);
        Commentary save = commentaryRepository.save(commentary);
//        save.getBook();
    }

    @Transactional(readOnly = true)
    public Commentary getOneById(Long id) {
        Commentary commentary = commentaryRepository.getOne(id);
        Hibernate.initialize(commentary.getReader());
        Hibernate.initialize(commentary.getBook());
        return commentary;
    }

    public List<Commentary> getCommentariesByReader(String name) {
        return commentaryRepository.findCommentaryByReader(name);
    }

    public List<Commentary> getAll() {
        return commentaryRepository.findAll();
    }

    public void deleteById(Long id) {
        commentaryRepository.deleteById(id);
    }

    public void deleteAll() {
        commentaryRepository.deleteAll();
    }
}
