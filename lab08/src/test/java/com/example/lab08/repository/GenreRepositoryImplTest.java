package com.example.lab08.repository;

import com.example.lab08.Lab08Application;
import com.example.lab08.domain.Author;
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

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Lab08Application.class, properties = {
        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT + ".enabled=false"
})
@ExtendWith(SpringExtension.class)
class GenreRepositoryImplTest {
    @Autowired
    GenreRepository genreRepository;

    @Test
    void createAndGetById() {
        String test = "test";
        Genre genre = new Genre();
        genre.setTitle(test);
        genre = genreRepository.create(genre);
        Assert.assertEquals(genre, genreRepository.getById(genre.getId()));
    }

    @Test
    void deleteAllAndGetAll() {
        genreRepository.deleteAll();

        List<Genre> genres = genreRepository.getAll();
        Assert.assertTrue(genres.isEmpty());
        String test = "test";
        String test1 = "test1";
        String test2 = "test2";
        List<Genre> tests = new ArrayList<>();
        tests.add(new Genre());
        tests.add(new Genre());
        tests.add(new Genre());
        tests.get(0).setTitle(test);
        tests.get(1).setTitle(test1);
        tests.get(2).setTitle(test2);
        for (Genre t: tests
        ) {
            t = genreRepository.create(t);
        }
        List<Genre> result = genreRepository.getAll();
        Assert.assertArrayEquals(tests.toArray(),result.toArray());
    }

    @Test
    void update() {
        genreRepository.deleteAll();
        String test = "test";
        Genre genre = new Genre();
        genre.setTitle(test);
        genre = genreRepository.create(genre);
        String test1 = "test1";
        genre.setTitle(test1);
        genreRepository.update(genre);

        Genre genre1 = genreRepository.getById(genre.getId());

        Assert.assertEquals(genre, genre1);
        Assert.assertEquals(test1, genre1.getTitle());

    }
    @Test
    @Transactional
    void deleteById(){
        genreRepository.deleteAll();
        String test = "test";
        Genre genre = new Genre();
        genre.setTitle(test);

        genre = genreRepository.create(genre);
        genreRepository.deleteElement(genre);

        List<Genre> genres = genreRepository.getAll();
        Assert.assertTrue(genres.isEmpty());
    }
}
