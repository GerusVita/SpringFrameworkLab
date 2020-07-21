package com.example.lab14.controller;

import com.example.lab14.domain.Book;
import com.example.lab14.domain.Commentary;
import com.example.lab14.domain.Reader;
import com.example.lab14.service.BookService;
import com.example.lab14.service.CommentaryService;
import com.example.lab14.service.ReaderService;
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
public class CommentController {
    @Autowired
    CommentaryService commentaryService;
    @Autowired
    ReaderService readerService;
    @Autowired
    BookService bookService;

    @GetMapping("/comment")
    public String getAllComments(Model model){
        model.addAttribute("comments",commentaryService.getAll());
        return "comment";
    }

    @GetMapping("/comment/new")
    public String newComment(Model model){
        model.addAttribute("comment",new Commentary());
        return "new/new-comment";
    }
    @GetMapping("/comment/update")
    public String updateComment(@PathVariable Long id,Model model){
        model.addAttribute("comment",commentaryService.getOneById(id));
        return "new/new-comment";
    }
    @PostMapping("/comment/save")
    public String saveComment(@ModelAttribute @Valid Commentary commentary, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("comment",commentary);
            return "new/new-comment";
        }
        Reader reader = readerService.getOneByName(commentary.getReader().getName());
        if(reader!=null)
            commentary.setReader(reader);
        Book book = bookService.getOneByTitle(commentary.getBook().getTitle());
        if(book!=null)
            commentary.setBook(book);
        commentaryService.addComment(commentary);
        return "redirect:/book";
    }
    @GetMapping("/comment/delete/{id}")
    public String deleteComment(@PathVariable Long id, Model model){
        commentaryService.deleteById(id);
        return "redirect:/comment";
    }
}
