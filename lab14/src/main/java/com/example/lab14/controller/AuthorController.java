package com.example.lab14.controller;

import com.example.lab14.domain.Author;
import com.example.lab14.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @GetMapping("/author")
    public String getAllAuthor(Model model){
        model.addAttribute("authors",authorService.allAuthors());
        return "author";
    }
    @GetMapping("/author/new")
    public String newAuthor(Model model){
        model.addAttribute("author",new Author());
        return "new/new-author";
    }
    @GetMapping("/author/update/{id}")
    public String updateAuthor(@PathVariable Long id,Model model){
        model.addAttribute("author",authorService.getOneById(id));
        return "new/new-author";
    }
    @PostMapping("/author/save")
    public String saveAuthor(@ModelAttribute @Valid Author author, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("author",author);
            return "new/new-author";
        }
        authorService.addAuthor(author);
        return "redirect:/author";
    }
    @GetMapping("/author/delete/{id}")
    public String deleteAuthor(@PathVariable Long id, Model model){
        authorService.deleteById(id);
        return "redirect:/author";
    }
}
