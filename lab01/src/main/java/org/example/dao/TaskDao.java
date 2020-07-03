package org.example.dao;

import org.example.domain.Task;

import java.io.Reader;
import java.util.List;

public interface TaskDao {
    Task findById(int id) throws Exception;

    List<String[]> readAllTask(Reader reader)  throws Exception;

}
