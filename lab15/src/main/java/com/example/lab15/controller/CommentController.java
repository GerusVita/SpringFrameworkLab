package com.example.lab15.controller;

import com.example.lab15.domain.Book;
import com.example.lab15.domain.Commentary;
import com.example.lab15.domain.Reader;
import com.example.lab15.service.BookService;
import com.example.lab15.service.CommentaryService;
import com.example.lab15.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class CommentController {
    @Autowired
    CommentaryService commentaryService;
    @Autowired
    ReaderService readerService;
    @Autowired
    BookService bookService;

    @GetMapping("/comment")
    public List<Commentary> getAllComments(){
        return commentaryService.getAll();
    }
    @GetMapping("/comment/{id}")
    public Commentary getOneComment(@PathVariable Long id){
        return commentaryService.getOneById(id);
    }
    @PostMapping("/comment/save")
    public void saveComment(@RequestBody @Valid Commentary commentary){
        commentaryService.addComment(commentary);
    }
    @DeleteMapping("/comment/{id}/delete")
    public void deleteComment(@PathVariable Long id){
        commentaryService.deleteById(id);
    }
}
