package com.example.lab14.controller;

import com.example.lab14.domain.Book;
import com.example.lab14.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/book")
    public String getAllBooks(Model model){
        model.addAttribute("books",bookService.getAll());
        return "book";
    }

    @GetMapping("/genre/books/{id}")
    public String getBookByGenre(@PathVariable Long id, Model model){
        model.addAttribute("books",bookService.getBooksByGenreId(id));
        return "book";
    }
    @GetMapping("/book/new")
    public String NewBook(Model model){
        model.addAttribute("book",new Book());
        return "new/new-book";
    }
    @GetMapping("/book/update/{id}")
    public String updateBook(@PathVariable Long id,Model model){
        model.addAttribute("book",bookService.getOneById(id));
        return "new/new-book";
    }
    @PostMapping("/book/save")
    public String saveBook(@ModelAttribute @Valid Book book, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("book",book);
            return "new/new-book";
        }
        bookService.addBook(book);
        return "redirect:/book";
    }
    @GetMapping("/book/{id}/delete")
    public String deleteBook(@PathVariable Long id, Model model){
        bookService.deleteById(id);
        return "redirect:/book";
    }
}
