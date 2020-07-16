package com.example.lab14.controller;

import com.example.lab14.domain.Reader;
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
public class ReaderController {
    @Autowired
    ReaderService readerService;

    @GetMapping("/reader")
    public String getAllReader(Model model){
        model.addAttribute("readers",readerService.allReader());
        return "reader";
    }
    @GetMapping("/reader/new")
    public String newReader(Model model){
        model.addAttribute("reader",new Reader());
        return "new/new-reader";
    }
    @GetMapping("/reader/update/{id}")
    public String updateReader(@PathVariable Long id,Model model){
        model.addAttribute("reader",readerService.getOneById(id));
        return "new/new-reader";
    }
    @PostMapping("/reader/save")
    public String saveReader(@ModelAttribute @Valid Reader reader, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("reader",reader);
            return "new/new-reader";
        }
        readerService.addReader(reader);
        return "redirect:/reader";
    }
    @GetMapping("/reader/delete/{id}")
    public String deleteReader(@PathVariable Long id, Model model){
        readerService.deleteOneById(id);
        return "redirect:/reader";
    }
}
