package com.example.lab05.dao;

import java.io.Reader;
import java.util.List;

public interface AnswerDao {
    List<String[]> readAllAnswer(Reader reader)  throws Exception;
}
