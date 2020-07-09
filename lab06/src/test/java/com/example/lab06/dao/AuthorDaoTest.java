package com.example.lab06.dao;

import com.example.lab06.Lab06Application;
import com.example.lab06.domain.Author;
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
class AuthorDaoTest {
    @Autowired
    AuthorDao authorDao;
    @Autowired
    BookDao bookDao;

    Author author;
    @Test
    void allAuthor() {
        String test1 = "test1";
        String test2 = "test2";
        String test3 = "test3";
        bookDao.deleteAll();
        authorDao.deleteAll();
        List<Author> authors = new ArrayList<>();
        authors.add(new Author(1,test1));
        authors.add(new Author(2,test2));
        authors.add(new Author(3,test3));
        for (Author authorN:authors
             ) {
            authorDao.create(authorN);
        }
        List<Author> result = authorDao.allAuthor();
        Assert.assertArrayEquals(authors.toArray(),result.toArray());
    }

    @Test
    void getOneByIdAndCreate() {
        String fullName = "Test";
        author = new Author(fullName);
        long id = authorDao.create(author);
        Assert.assertEquals(author,authorDao.getOneById(id));
    }

    @Test
    void updateAndDelete() {
        String fullName = "Test";
        author = new Author(fullName);
        long id = authorDao.create(author);
        Assert.assertEquals(author,authorDao.getOneById(id));
        String fullName1 = "Test1";
        author.setFullName(fullName1);
        author.setId(id);
        Assert.assertEquals(1,authorDao.update(author));
        bookDao.deleteAll();
        Assert.assertEquals(1,authorDao.deleteById(author.getId()));
    }

    @Test
    void deleteAll() {
        bookDao.deleteAll();
        authorDao.deleteAll();
        List<Author> authors = new ArrayList<>();
        Assert.assertTrue(authorDao.allAuthor().isEmpty());
    }
}
