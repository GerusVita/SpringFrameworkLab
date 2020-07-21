package com.example.lab15.service;

import com.example.lab15.domain.Author;
import com.example.lab15.domain.Book;
import com.example.lab15.domain.Genre;
import com.example.lab15.repository.BookRepository;
import org.hibernate.Hibernate;
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

    public void addBook(Book book) {
        Author author = authorService.getOneByName(book.getAuthor().getFullName());
        if (author != null)
            book.setAuthor(author);
        Genre genre = genreService.getOneByTitle(book.getGenre().getTitle());
        if (genre != null)
            book.setGenre(genre);
        bookRepository.save(book);
    }

    public List<Book> getAll() {
        List<Book> list = bookRepository.findAll();
        list.forEach(book -> Hibernate.initialize(book.getComments()));
        return list;
    }

    public Book getOneByTitle(String name) {
        return bookRepository.findBookByTitle(name);
    }

    @Transactional(readOnly = true)
    public Book getOneById(Long id) {
        Book book = bookRepository.getOne(id);
        Hibernate.initialize(book.getAuthor());
        Hibernate.initialize(book.getGenre());
        return book;
    }

    public List<Book> getBooksByGenreId(Long id) {
        List<Book> books = bookRepository.getBooksByGenre_Id(id);
        books.forEach(book -> Hibernate.initialize(book.getComments()));
        return books;
    }

    public void deleteByTitle(String name) {
        bookRepository.deleteBookByTitle(name);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    public void deleteAll() {
        bookRepository.deleteAll();
    }
}
