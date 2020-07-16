package com.example.lab14.controller;

import com.example.lab14.domain.Genre;
import com.example.lab14.service.GenreService;
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
public class GenreController {
    @Autowired
    private GenreService genreService;

    @GetMapping("/genre")
    public String allGenre(Model model){
        model.addAttribute("genres",genreService.allGenre());
        return "genre";
    }

    @GetMapping("/genre/new")
    public String newGenre(Model model){
        model.addAttribute("genre",new Genre());
        return "new/new-genre";
    }
    @GetMapping("/genre/update/{id}")
    public String updateGenre(@PathVariable Long id,Model model){
        model.addAttribute("genre",genreService.getOneById(id));
        return "new/new-genre";
    }
    @PostMapping("/genre/save")
    public String saveGenre(@ModelAttribute @Valid Genre genre, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("genre",genre);
            return "new/new-genre";
        }
        genreService.addGenre(genre);
        return "redirect:/genre";
    }
    @GetMapping("/genre/delete/{id}")
    public String deleteGenre(@PathVariable Long id, Model model){
        genreService.deleteById(id);
        return "redirect:/genre";
    }
}
