package com.example.lab08.repository;

import com.example.lab08.Lab08Application;
import com.example.lab08.domain.Author;
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
class AuthorRepositoryImplTest {
    @Autowired
    AuthorRepository authorRepository;

    @Test
    void createAndGetById() {
        String test = "test";
        Author author = new Author();
        author.setFullName(test);
        author = authorRepository.create(author);
        Assert.assertEquals(author, authorRepository.getById(author.getId()));
    }

    @Test
    void deleteAllAndGetAll() {
        authorRepository.deleteAll();
        List<Author> authors = authorRepository.getAll();
        Assert.assertTrue(authors.isEmpty());
        String test = "test";
        String test1 = "test1";
        String test2 = "test2";
        List<Author> tests = new ArrayList<>();
        tests.add(new Author());
        tests.add(new Author());
        tests.add(new Author());
        tests.get(0).setFullName(test);
        tests.get(1).setFullName(test1);
        tests.get(2).setFullName(test2);
        for (Author t: tests
             ) {
            t = authorRepository.create(t);
        }
        List<Author> result = authorRepository.getAll();
        Assert.assertArrayEquals(tests.toArray(),result.toArray());
    }

    @Test
    void update() {
        authorRepository.deleteAll();
        String test = "test";
        Author author = new Author();
        author.setFullName(test);
        author = authorRepository.create(author);
        String test1 = "test1";
        author.setFullName(test1);
        authorRepository.update(author);

        Author author1 = authorRepository.getById(author.getId());

        Assert.assertEquals(test1, author1.getFullName());
    }
    @Test
    @Transactional
    void deleteById(){
        authorRepository.deleteAll();
        String test = "test";
        Author author = new Author();
        author.setFullName(test);

        author = authorRepository.create(author);
        authorRepository.deleteElement(author);

        List<Author> authors = authorRepository.getAll();
        Assert.assertTrue(authors.isEmpty());
    }
}
