package com.example.lab06.shell;

import com.example.lab06.dao.AuthorDao;
import com.example.lab06.dao.BookDao;
import com.example.lab06.dao.GenreDao;
import com.example.lab06.domain.Author;
import com.example.lab06.domain.Book;
import com.example.lab06.domain.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.ArrayList;
import java.util.List;

@ShellComponent
public class ShellCommand {
    @Autowired
    AuthorDao authorDao;
    @Autowired
    BookDao bookDao;
    @Autowired
    GenreDao genreDao;

    Author author;
    Book book;
    Genre genre;

    @ShellMethod("Add record to table author")
    public long addAuthor(@ShellOption String name){
        author = new Author(name);
        return authorDao.create(author);
    }
    @ShellMethod("Add record to table genre")
    public long addGenre(@ShellOption String name){
        genre = new Genre(name);
        return genreDao.create(genre);
    }
    @ShellMethod("Add record to table book")
    public long addBook(@ShellOption String name,@ShellOption long idAuthor,@ShellOption long idGenre){
        book = new Book(name,idAuthor,idGenre);
        return bookDao.create(book);
    }
    @ShellMethod("Read selected table")
    public List<String> readAll(@ShellOption String name){
        List<String> read = new ArrayList<>();
        switch (name){
            case "author":
                for (Author one: authorDao.allAuthor()
                     ) {
                    read.add(one.toString());
                }
              return read;
            case "book":
                for (Book one: bookDao.allBook()
                ) {
                    read.add(one.toString());
                }
                return read;
            case "genre":
                for (Genre one: genreDao.allGenre()
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
    public List<String> deleteAll(@ShellOption String name){
        List<String> delete = new ArrayList<>();
        switch (name){
            case "author":
                authorDao.deleteAll();
                for (Author one: authorDao.allAuthor()
                ) {
                    delete.add(one.toString());
                }
                return delete;
            case "book":
                bookDao.deleteAll();
                for (Book one: bookDao.allBook()
                ) {
                    delete.add(one.toString());
                }
                return delete;
            case "genre":
                genreDao.deleteAll();
                for (Genre one: genreDao.allGenre()
                ) {
                    delete.add(one.toString());
                }
                return delete;
            default:
                delete.add("no table selected");
                return delete;
        }
    }
    @ShellMethod("Update record to table author")
    public int updateAuthor(@ShellOption long id,@ShellOption String name){
        author = new Author(id,name);
        return authorDao.update(author);
    }
    @ShellMethod("Update record to table genre")
    public int updateGenre(@ShellOption long id,@ShellOption String name){
        genre = new Genre(id,name);
        return genreDao.update(genre);
    }
    @ShellMethod("Update record to table book")
    public int updateBook(@ShellOption long id,@ShellOption String name,@ShellOption long idAuthor,@ShellOption long idGenre){
        book = new Book(id,name,idAuthor,idGenre);
        return bookDao.update(book);
    }
    @ShellMethod("Delete record to table author")
    public int deleteAuthor(@ShellOption long id){
        return authorDao.deleteById(id);
    }
    @ShellMethod("Delete record to table genre")
    public int deleteGenre(@ShellOption long id){
        return genreDao.deleteById(id);
    }
    @ShellMethod("Delete record to table book")
    public int deleteBook(@ShellOption long id){
        return bookDao.deleteByID(id);
    }
    @ShellMethod("Get record from table author by id")
    public String getAuthor(@ShellOption long id){
        return authorDao.getOneById(id).toString();
    }
    @ShellMethod("Get record from table genre by id")
    public String getGenre(@ShellOption long id){
        return genreDao.getOneById(id).toString();
    }
    @ShellMethod("Get record from table book by id")
    public String getBook(@ShellOption long id){
        return bookDao.getOneById(id).toString();
    }
}
