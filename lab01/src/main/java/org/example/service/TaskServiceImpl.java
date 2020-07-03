package org.example.service;

import com.opencsv.CSVReader;
import org.example.dao.TaskDao;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class TaskServiceImpl implements TaskService {

    TaskDao dao;
    public TaskServiceImpl(TaskDao dao) {
        this.dao = dao;
    }

    public  List<String[]> AllTask() throws Exception {
        Reader reader = new FileReader(ClassLoader.getSystemResource("csv/TasksList.csv").getFile());
        return dao.readAllTask(reader);
    }
}
