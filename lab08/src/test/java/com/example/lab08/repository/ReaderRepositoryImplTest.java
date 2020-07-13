package com.example.lab08.repository;

import com.example.lab08.Lab08Application;
import com.example.lab08.domain.Reader;
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
class ReaderRepositoryImplTest {
    @Autowired
    ReaderRepository readerRepository;

    @Test
    void createAndGetById() {
        String test = "test";
        Reader reader = new Reader();
        reader.setName(test);
        reader = readerRepository.create(reader);
        Assert.assertEquals(reader, readerRepository.getById(reader.getId()));
    }

    @Test
    void deleteAllAndGetAll() {
        readerRepository.deleteAll();

        List<Reader> readers = readerRepository.getAll();
        Assert.assertTrue(readers.isEmpty());
        String test = "test";
        String test1 = "test1";
        String test2 = "test2";
        List<Reader> tests = new ArrayList<>();
        tests.add(new Reader());
        tests.add(new Reader());
        tests.add(new Reader());
        tests.get(0).setName(test);
        tests.get(1).setName(test1);
        tests.get(2).setName(test2);
        for (Reader t : tests
        ) {
            t = readerRepository.create(t);
        }
        List<Reader> result = readerRepository.getAll();
        Assert.assertArrayEquals(tests.toArray(), result.toArray());
    }

    @Test
    void update() {
        readerRepository.deleteAll();
        String test = "test";
        Reader reader = new Reader();
        reader.setName(test);
        reader = readerRepository.create(reader);
        String test1 = "test1";
        reader.setName(test1);
        readerRepository.update(reader);

        Reader reader1 = readerRepository.getById(reader.getId());

        Assert.assertEquals(reader, reader1);
        Assert.assertEquals(test1, reader1.getName());

    }

    @Test
    @Transactional
    void deleteById() {
        readerRepository.deleteAll();
        String test = "test";
        Reader reader = new Reader();
        reader.setName(test);

        reader = readerRepository.create(reader);
        readerRepository.deleteElement(reader);

        List<Reader> readers = readerRepository.getAll();
        Assert.assertTrue(readers.isEmpty());
    }
}
