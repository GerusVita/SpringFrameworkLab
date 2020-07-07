package com.example.lab04.dao;

import org.springframework.stereotype.Repository;

import java.io.Reader;
import java.util.List;
public interface AnswerDao {
    List<String[]> readAllAnswer(Reader reader)  throws Exception;
}
