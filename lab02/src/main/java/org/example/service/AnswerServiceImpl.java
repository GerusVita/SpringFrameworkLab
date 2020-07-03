package org.example.service;

import org.example.dao.AnswerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.Reader;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService{
    AnswerDao daoAnswer;

    @Autowired
    public AnswerServiceImpl(AnswerDao dao) {
        this.daoAnswer = dao;
    }

    @Override
    public List<String[]> AllAnswer() throws Exception {
        Reader reader = new FileReader(ClassLoader.getSystemResource("csv/AnswerOnTask.csv").getFile());
        return daoAnswer.readAllAnswer(reader);
    }
}
