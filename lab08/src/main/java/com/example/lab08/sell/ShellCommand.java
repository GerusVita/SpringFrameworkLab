package com.example.lab08.sell;

import com.example.lab08.domain.*;
import com.example.lab08.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.ArrayList;
import java.util.List;
@ShellComponent
public class ShellCommand {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CommentaryRepository commentaryRepository;
    @Autowired
    GenreRepository genreRepository;
    @Autowired
    ReaderRepository readerRepository;

    Author author;
    Book book;
    Commentary commentary;
    Genre genre;
    Reader reader;

    @ShellMethod("Add record to table author")
    public String addAuthor(@ShellOption String name){
        author = new Author();
        author.setFullName(name);
        author = authorRepository.create(author);
        return author.toString();
    }
    @ShellMethod("Add record to table genre")
    public String addGenre(@ShellOption String name){
        genre = new Genre();
        genre.setTitle(name);
        genre = genreRepository.create(genre);
        return genre.toString();
    }
    @ShellMethod("Add record to table commentary")
    public String addComment(@ShellOption String name,@ShellOption long readerId,@ShellOption long bookId){
        commentary = new Commentary();
        reader = readerRepository.getById(readerId);
        book = bookRepository.getById(bookId);
        commentary.setReader(reader);
        commentary.setBook(book);
        commentary.setText(name);
        commentary =  commentaryRepository.create(commentary);
        return commentary.toString();
    }
    @ShellMethod("Add record to table book")
    public String addBook(@ShellOption String name,@ShellOption long idAuthor,@ShellOption long idGenre){
        book = new Book();
        author = authorRepository.getById(idAuthor);
        genre = genreRepository.getById(idGenre);
        book.setAuthor(author);
        book.setGenre(genre);
        book.setTitle(name);
        book =  bookRepository.create(book);
        return book.toString();
    }
    @ShellMethod("Add record to table reader")
    public String addReader(@ShellOption String name){
        reader = new Reader();
        reader.setName(name);
        reader = readerRepository.create(reader);
        return reader.toString();
    }

    @ShellMethod("Read selected table")
    public List<String> readAll(@ShellOption String name){
        List<String> read = new ArrayList<>();
        switch (name){
            case "author":
                for (Author one: authorRepository.getAll()
                ) {
                    read.add(one.toString());
                }
                return read;
            case "book":
                for (Book one: bookRepository.getAll()
                ) {
                    read.add(one.toString());
                }
                return read;
            case "genre":
                for (Genre one: genreRepository.getAll()
                ) {
                    read.add(one.toString());
                }
                return read;
            case "comment":
                for (Commentary one: commentaryRepository.getAll()
                ) {
                    read.add(one.toString());
                }
                return read;
            case "reader":
                for (Reader one: readerRepository.getAll()
                ) {
                    read.add(one.toString());
                }
                return read;
            default:
                read.add("no table selected");
                return read;
        }
    }
    @ShellMethod("Delete all to selected table")
    public void deleteAll(@ShellOption String name){
        List<String> delete = new ArrayList<>();
        switch (name){
            case "author":
                authorRepository.deleteAll();break;
            case "book":
                bookRepository.deleteAll();break;
            case "genre":
                genreRepository.deleteAll();break;
            case "comment":
                commentaryRepository.deleteAll();break;
            case "reader":
                readerRepository.deleteAll();break;
            default:
                delete.add("no table selected");break;
        }
    }
    @ShellMethod("Update record to table author")
    public String updateAuthor(@ShellOption long id,@ShellOption String name){
        author = new Author();
        author.setId(id);
        author.setFullName(name);
        authorRepository.update(author);
        return author.toString();
    }
    @ShellMethod("Update record to table genre")
    public String updateGenre(@ShellOption long id,@ShellOption String name){
        genre = new Genre();
        genre.setId(id);
        genre.setTitle(name);
        genreRepository.update(genre);
        return genre.toString();
    }
    @ShellMethod("Update record to table book")
    public String updateBook(@ShellOption long id,@ShellOption String name,@ShellOption long idAuthor,@ShellOption long idGenre){
        book = new Book();
        book.setId(id);
        book.setTitle(name);
        author = authorRepository.getById(idAuthor);
        genre = genreRepository.getById(idGenre);
        book.setAuthor(author);
        book.setGenre(genre);
        bookRepository.update(book);
        return book.toString();
    }
    @ShellMethod("Update record to table commentary")
    public String updateComment(@ShellOption long id,@ShellOption String name,@ShellOption long readerId,@ShellOption long bookId){
        commentary = new Commentary();
        commentary.setId(id);
        reader = readerRepository.getById(readerId);
        book = bookRepository.getById(bookId);
        commentary.setReader(reader);
        commentary.setBook(book);
        commentary.setText(name);
        commentaryRepository.update(commentary);
        return commentary.toString();
    }
    @ShellMethod("Update record to table reader")
    public String updateReader(@ShellOption long id,@ShellOption String name){
        reader = new Reader();
        reader.setId(id);
        reader.setName(name);
        readerRepository.update(reader);
        return reader.toString();
    }
    @ShellMethod("Delete record to table author")
    public void deleteAuthor(@ShellOption long id){
        authorRepository.deleteElement(authorRepository.getById(id));
    }
    @ShellMethod("Delete record to table genre")
    public void deleteGenre(@ShellOption long id){
        genreRepository.deleteElement(genreRepository.getById(id));
    }
    @ShellMethod("Delete record to table book")
    public void deleteBook(@ShellOption long id){
        bookRepository.deleteElement(bookRepository.getById(id));
    }
    @ShellMethod("Delete record to table commentary")
    public void deleteComment(@ShellOption long id){
        commentaryRepository.deleteElement(commentaryRepository.getById(id));
    }
    @ShellMethod("Delete record to table reader")
    public void deleteReader(@ShellOption long id){
        readerRepository.deleteElement(readerRepository.getById(id));
    }
    @ShellMethod("Get record from table author by id")
    public String getAuthor(@ShellOption long id){
        return authorRepository.getById(id).toString();
    }
    @ShellMethod("Get record from table genre by id")
    public String getGenre(@ShellOption long id){
        return genreRepository.getById(id).toString();
    }
    @ShellMethod("Get record from table book by id")
    public String getBook(@ShellOption long id){
        return bookRepository.getById(id).toString();
    }
    @ShellMethod("Get record from table commentary by id")
    public String getComment(@ShellOption long id){
        return commentaryRepository.getById(id).toString();
    }
    @ShellMethod("Get record from table reader by id")
    public String getReader(@ShellOption long id){
        return readerRepository.getById(id).toString();
    }
}
