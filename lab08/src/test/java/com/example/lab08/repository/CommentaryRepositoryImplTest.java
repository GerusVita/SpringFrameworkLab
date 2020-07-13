package com.example.lab08.repository;

import com.example.lab08.Lab08Application;
import com.example.lab08.domain.*;
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
class CommentaryRepositoryImplTest {

    @Autowired
    CommentaryRepository commentaryRepository;

    @Test
    void createAndGetById() {
        String test = "test";
        Commentary com = new Commentary();

        Author author = new Author();
        author.setFullName("test");
        Genre genre = new Genre();
        genre.setTitle("test");
        Book book = new Book();
        book.setTitle(test);
        book.setAuthor(author);
        book.setGenre(genre);

        Reader reader = new Reader();
        reader.setName(test);

        com.setText(test);
        com.setBook(book);
        com.setReader(reader);
        com = commentaryRepository.create(com);
        Assert.assertEquals(com, commentaryRepository.getById(com.getId()));
    }

    @Test
    void update() {
        Author author = new Author();
        author.setFullName("test");
        Genre genre = new Genre();
        genre.setTitle("test");
        Book book = new Book();
        book.setTitle("test");
        book.setAuthor(author);
        book.setGenre(genre);
        Reader reader =new Reader();
        reader.setName("test");

        commentaryRepository.deleteAll();
        String test = "test";
        Commentary com = new Commentary();
        com.setText(test);
        com.setBook(book);
        com.setReader(reader);
        com = commentaryRepository.create(com);
        String test1 = "test1";
        com.setText(test1);
        commentaryRepository.update(com);

        Commentary commentary = commentaryRepository.getById(com.getId());

        Assert.assertEquals(com, commentary);
    }

    @Test
    void getAllAndDeleteAll() {
        Author author = new Author();
        author.setFullName("test");
        Genre genre = new Genre();
        genre.setTitle("test");
        Book book = new Book();
        book.setTitle("test");
        book.setGenre(genre);
        book.setAuthor(author);
        Reader reader = new Reader();
        reader.setName("test");

        String test = "test";
        String test1 = "test1";
        String test2 = "test2";

        List<Commentary> tests = new ArrayList<>();

        tests.add(new Commentary());
        tests.add(new Commentary());
        tests.add(new Commentary());
        tests.get(0).setText(test);
        tests.get(0).setBook(book);
        tests.get(0).setReader(reader);
        tests.get(1).setText(test1);
        tests.get(1).setBook(book);
        tests.get(1).setReader(reader);
        tests.get(2).setText(test2);
        tests.get(2).setBook(book);
        tests.get(2).setReader(reader);

        for (Commentary t: tests
        ) {
            t = commentaryRepository.create(t);
        }
        List<Commentary> result = commentaryRepository.getAll();
        Assert.assertArrayEquals(tests.toArray(),result.toArray());
    }

    @Test
    @Transactional
    void deleteById(){
        Author author = new Author();
        author.setFullName("test");
        Genre genre = new Genre();
        genre.setTitle("test");
        Book book = new Book();
        book.setTitle("test");
        book.setGenre(genre);
        book.setAuthor(author);
        Reader reader = new Reader();
        reader.setName("test");

        commentaryRepository.deleteAll();
        String test = "test";
        Commentary com = new Commentary();
        com.setText(test);
        com.setBook(book);
        com.setReader(reader);
        com = commentaryRepository.create(com);

        commentaryRepository.deleteElement(com);

        List<Commentary> commentaries = commentaryRepository.getAll();
        Assert.assertTrue(commentaries.isEmpty());
    }
}
