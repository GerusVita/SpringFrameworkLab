package com.example.lab08.repository;

import com.example.lab08.Lab08Application;
import com.example.lab08.domain.Author;
import com.example.lab08.domain.Book;
import com.example.lab08.domain.Genre;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = Lab08Application.class, properties = {
        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT + ".enabled=false"
})
@ExtendWith(SpringExtension.class)
class BookRepositoryImplTest {
    @Autowired
    BookRepository bookRepository;

    @Test
    void createAndGetById() {
        String test = "test";
        Book book = new Book();
        Author author = new Author();
        author.setFullName("test");
        Genre genre = new Genre();
        genre.setTitle("test");
        book.setTitle(test);
        book.setAuthor(author);
        book.setGenre(genre);
        book = bookRepository.create(book);
        Assert.assertEquals(book, bookRepository.getById(book.getId()));
    }

    @Test
    void deleteAllAndGetAll() {
        Author author = new Author();
        author.setFullName("test");
        Genre genre = new Genre();
        genre.setTitle("test");

        bookRepository.deleteAll();
        List<Book> books = bookRepository.getAll();
        Assert.assertTrue(books.isEmpty());
        String test = "test";
        String test1 = "test1";
        String test2 = "test2";
        List<Book> tests = new ArrayList<>();
        tests.add(new Book());
        tests.add(new Book());
        tests.add(new Book());
        tests.get(0).setTitle(test);
        tests.get(0).setAuthor(author);
        tests.get(0).setGenre(genre);
        tests.get(1).setTitle(test1);
        tests.get(1).setAuthor(author);
        tests.get(1).setGenre(genre);
        tests.get(2).setTitle(test2);
        tests.get(2).setAuthor(author);
        tests.get(2).setGenre(genre);

        for (Book t: tests
        ) {
            t = bookRepository.create(t);
        }
        List<Book> result = bookRepository.getAll();
        Assert.assertArrayEquals(tests.toArray(),result.toArray());
    }

    @Test
    void update() {
        Author author = new Author();
        author.setFullName("test");
        Genre genre = new Genre();
        genre.setTitle("test");

        bookRepository.deleteAll();
        String test = "test";
        Book book = new Book();
        book.setTitle(test);
        book.setAuthor(author);
        book.setGenre(genre);
        book = bookRepository.create(book);
        String test1 = "test1";
        book.setTitle(test1);
        bookRepository.update(book);

        Book book1 = bookRepository.getById(book.getId());

        Assert.assertEquals(book, book1);
    }
    @Test
    @Transactional
    void deleteById(){
        Author author = new Author();
        author.setFullName("test");
        Genre genre = new Genre();
        genre.setTitle("test");

        bookRepository.deleteAll();
        String test = "test";
        Book book = new Book();
        book.setTitle(test);
        book.setAuthor(author);
        book.setGenre(genre);

        book = bookRepository.create(book);
        bookRepository.deleteElement(book);

        List<Book> books = bookRepository.getAll();
        Assert.assertTrue(books.isEmpty());
    }
}
