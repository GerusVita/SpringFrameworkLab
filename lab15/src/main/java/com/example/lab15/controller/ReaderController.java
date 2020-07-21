package com.example.lab15.controller;

import com.example.lab15.domain.Reader;
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
public class ReaderController {
    @Autowired
    ReaderService readerService;

    @GetMapping("/reader")
    public List<Reader> getAllReader() {
        return readerService.allReader();
    }
    @GetMapping("/reader/{id}")
    public Reader getOneReader(@PathVariable Long id) {
        return readerService.getOneById(id);
    }

    @PostMapping("/reader/save")
    public void saveReader(@RequestBody @Valid Reader reader) {
        readerService.addReader(reader);
    }

    @DeleteMapping("/reader/{id}/delete")
    public void deleteReader(@PathVariable Long id) {
        readerService.deleteOneById(id);
    }
}
