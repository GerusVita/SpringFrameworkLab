package org.example.domain;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Task {
    private List<String[]> taskForTest;
    //throws Exception ???
    public Task(){
        this.taskForTest = new ArrayList<String[]>();
    }

    public List<String[]> getTaskForTest() {
        return taskForTest;
    }

    public void setTaskForTest(List<String[]> taskForTest) {
        this.taskForTest = taskForTest;
    }
}
