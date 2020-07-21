package com.example.lab14.service;

import com.example.lab14.domain.Commentary;
import com.example.lab14.repository.CommentaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentaryService {
    @Autowired
    CommentaryRepository commentaryRepository;

    public void addComment(Commentary commentary){
        commentaryRepository.save(commentary);
    }
    public Commentary getOneById(Long id){
        return commentaryRepository.getOne(id);
    }
    public List<Commentary> getCommentariesByReader(String name){
        return commentaryRepository.findCommentaryByReader(name);
    }
    public List<Commentary> getAll(){
        return commentaryRepository.findAll();
    }
    public void deleteById(Long id){
        commentaryRepository.deleteById(id);
    }
    public void deleteAll(){
        commentaryRepository.deleteAll();
    }
}
