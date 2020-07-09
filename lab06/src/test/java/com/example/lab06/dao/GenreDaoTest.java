package com.example.lab06.dao;

import com.example.lab06.Lab06Application;
import com.example.lab06.domain.Genre;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = Lab06Application.class)
@ExtendWith(SpringExtension.class)
class GenreDaoTest {
    @Autowired
    GenreDao genreDao;
    @Autowired
    BookDao bookDao;

    Genre genre;
    @Test
    void allAuthor() {
        String test1 = "test1";
        String test2 = "test2";
        String test3 = "test3";
        bookDao.deleteAll();
        genreDao.deleteAll();
        List<Genre> genres = new ArrayList<>();
        genres.add(new Genre(1,test1));
        genres.add(new Genre(2,test2));
        genres.add(new Genre(3,test3));
        for (Genre authorN:genres
        ) {
            genreDao.create(authorN);
        }
        List<Genre> result = genreDao.allGenre();
        Assert.assertArrayEquals(genres.toArray(),result.toArray());
    }

    @Test
    void getOneByIdAndCreate() {
        String title = "Test";
        genre = new Genre(title);
        long id = genreDao.create(genre);
        Assert.assertEquals(genre,genreDao.getOneById(id));
    }

    @Test
    void updateAndDelete() {
        String title = "Test";
        genre = new Genre(title);
        long id = genreDao.create(genre);
        String title1 = "Test1";
        genre.setTitle(title1);
        genre.setId(id);
        Assert.assertEquals(1,genreDao.update(genre));
        bookDao.deleteAll();
        Assert.assertEquals(1,genreDao.deleteById(genre.getId()));
    }

    @Test
    void deleteAll() {
        bookDao.deleteAll();
        genreDao.deleteAll();
        List<Genre> authors = new ArrayList<>();
        Assert.assertTrue(genreDao.allGenre().isEmpty());
    }
}
