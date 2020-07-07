package com.example.lab04.service;

import com.example.lab04.domain.AnswerOnTask;
import com.example.lab04.domain.Person;
import org.springframework.stereotype.Service;

import java.util.Locale;

public interface MessegeService {
    String getSurnameMessage(Locale locale);
    String getNameMessage(Locale locale);
    String getQuestionMessage(Locale locale,int i);
    String getQuestionsMessage(Locale locale);
    String getResultMessage(Locale locale,Person person);
}
