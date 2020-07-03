package org.example.service;

import org.example.dao.AnswerDao;
import org.example.dao.AnswerDaoAll;

import java.io.FileReader;
import java.io.Reader;
import java.util.List;

public class AnswerServiceImpl implements AnswerService{
    AnswerDao daoAnswer;

    public AnswerServiceImpl(AnswerDaoAll dao) {
        this.daoAnswer = dao;
    }

    @Override
    public List<String[]> AllAnswer() throws Exception {
        Reader reader = new FileReader(ClassLoader.getSystemResource("csv/AnswerOnTask.csv").getFile());
        return daoAnswer.readAllAnswer(reader);
    }
}
