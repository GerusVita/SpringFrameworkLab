package com.example.lab14.service;

import com.example.lab14.domain.Author;
import com.example.lab14.domain.Book;
import com.example.lab14.domain.Genre;
import com.example.lab14.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private GenreService genreService;

    public void addBook(Book book){
        Author author = authorService.getOneByName(book.getAuthor().getFullName());
        if(author!=null)
            book.setAuthor(author);
        Genre genre = genreService.getOneByTitle(book.getGenre().getTitle());
        if(genre!=null)
            book.setGenre(genre);
        bookRepository.save(book);
    }
    public List<Book> getAll(){
        return bookRepository.findAll();
    }
    public Book getOneByTitle(String name){
        return bookRepository.findBookByTitle(name);
    }
    public Book getOneById(Long id){
        return bookRepository.getOne(id);
    }
    public List<Book> getBooksByGenreId(Long id){
        return bookRepository.getBooksByGenre_Id(id);
    }
    public void deleteByTitle(String name){
        bookRepository.deleteBookByTitle(name);
    }
    public void deleteById(Long id){
        bookRepository.deleteById(id);
    }
    public void deleteAll(){
        bookRepository.deleteAll();
    }
}
