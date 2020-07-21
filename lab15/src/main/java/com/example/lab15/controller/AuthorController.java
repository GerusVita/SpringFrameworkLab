package com.example.lab15.controller;

import com.example.lab15.domain.Author;
import com.example.lab15.service.AuthorService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @GetMapping("/author")
    public List<Author> getAllAuthor() {
        return authorService.allAuthors();
    }

    @GetMapping("/author/{id}")
    public Author getOneAuthor(@PathVariable Long id) {
        return authorService.getOneById(id);
    }

    @PostMapping("/author/save")
    public void saveAuthor(@RequestBody @Valid Author author) {
        authorService.addAuthor(author);
    }

    @DeleteMapping("/author/{id}/delete")
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteById(id);
    }
}
