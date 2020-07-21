package com.example.lab15.controller;

import com.example.lab15.domain.Genre;
import com.example.lab15.service.GenreService;
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
public class GenreController {
    @Autowired
    private GenreService genreService;

    @GetMapping("/genre")
    public List<Genre> allGenre(){
        return genreService.allGenre();
    }
    @GetMapping("/genre/{id}")
    public Genre getOneGenre(@PathVariable Long id){
        return genreService.getOneById(id);
    }
    @PostMapping("/genre/save")
    public void saveGenre(@RequestBody @Valid Genre genre){
        genreService.addGenre(genre);
    }
    @DeleteMapping("/genre/{id}/delete")
    public void deleteGenre(@PathVariable Long id){
        genreService.deleteById(id);
    }
}
