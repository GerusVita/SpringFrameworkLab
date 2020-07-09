package com.example.lab06.dao;

import com.example.lab06.Lab06Application;
import com.example.lab06.domain.Author;
import com.example.lab06.domain.Book;
import com.example.lab06.domain.Genre;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = Lab06Application.class)
@ExtendWith(SpringExtension.class)
class BookDaoTest {
    @Autowired
    BookDao bookDao;

    Author author;
    Genre genre;

    @Autowired
    public BookDaoTest(GenreDao genreDao,AuthorDao authorDao) {
        this.author = new Author();
        this.genre = new Genre();
        author.setId(authorDao.create(this.author));
        genre.setId(genreDao.create(this.genre));
    }

    Book book;
    @Test
    void allAuthor() {
        String test1 = "test1";
        String test2 = "test2";
        String test3 = "test3";
        bookDao.deleteAll();
        List<Book> books = new ArrayList<>();
        books.add(new Book(1,test1,author.getId(),genre.getId()));
        books.add(new Book(2,test2,author.getId(),genre.getId()));
        books.add(new Book(3,test3,author.getId(),genre.getId()));
        for (Book book1:books
        ) {
            book1.setId(bookDao.create(book1));
        }
        List<Book> result = bookDao.allBook();
        Assert.assertArrayEquals(books.toArray(),result.toArray());
    }

    @Test
    void getOneByIdAndCreate() {
        String test = "Test";
        book = new Book(test,author.getId(),genre.getId());
        long id = bookDao.create(book);
        Assert.assertEquals(book,bookDao.getOneById(id));
    }

    @Test
    void updateAndDelete() {
        String test = "Test";
        book = new Book(test,author.getId(),genre.getId());
        long id = bookDao.create(book);
        String test1 = "Test1";
        book.setTitle(test1);
        book.setId(id);
        Assert.assertEquals(1,bookDao.update(book));
        Assert.assertEquals(1,bookDao.deleteByID(book.getId()));
    }

    @Test
    void deleteAll() {
        bookDao.deleteAll();
        List<Book> books = new ArrayList<>();
        Assert.assertTrue(bookDao.allBook().isEmpty());
    }
}
