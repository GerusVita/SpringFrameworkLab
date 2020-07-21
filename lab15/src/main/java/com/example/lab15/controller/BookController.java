package com.example.lab15.controller;

import com.example.lab15.domain.Book;
import com.example.lab15.service.BookService;
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
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/book")
    public List<Book> getAllBooks(){
        return bookService.getAll();
    }

    @GetMapping("/book/genre/{id}")
    public List<Book> getBookByGenre(@PathVariable Long id){
        return bookService.getBooksByGenreId(id);
    }

    @GetMapping("/book/{id}")
    public Book getOneBook(@PathVariable Long id){
        return bookService.getOneById(id);
    }
    @PostMapping("/book/save")
    public void saveBook(@RequestBody @Valid Book book){
        bookService.addBook(book);
    }
    @DeleteMapping("/book/{id}/delete")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteById(id);
    }
}
